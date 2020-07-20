package ru.job4j.tracker;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class StartUITest {

    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
    @Test
    public void createItem() throws SQLException {
        SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()));
        //tracker.init();
        tracker.add(new Item("Some name"));
        assertThat(tracker.findByName("Some name").size(), is(1));
    }
    @Test
    public void whenAddItem() throws SQLException {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Store memTracker =new SqlTracker(ConnectionRollback.create(this.init()));
        CreateAction action = new CreateAction();
        action.execute(input, memTracker);
        Item created = memTracker.findAll().get(memTracker.findAll().size() - 1);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() throws SQLException {
        Store memTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("new item");
        memTracker.add(item);
        String[] answers = {
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        EditItem action = new EditItem();
        StubInput input = new StubInput(
                answers
        );
        action.execute(input, memTracker);
        Item replaced = memTracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void  whenDeleteItem() throws SQLException {
        Store memTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("new item");
        memTracker.add(item);
        DeleteItem action = new DeleteItem();
        StubInput input = new StubInput(
                new String[] {item.getId()}
        );
        action.execute(input, memTracker);
        Item replaced = memTracker.findById(item.getId());
        assertNull(replaced);
    }
    @Test
    public void whenExit() throws SQLException {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        ArrayList<UserAction> userActions = new ArrayList<>();
        userActions.add(action);
        new StartUI().init(input, new SqlTracker(ConnectionRollback.create(this.init())), userActions );
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenPrtMenu() throws SQLException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        ArrayList<UserAction> userActions = new ArrayList<>();
        userActions.add(action);
        new StartUI().init(input, new SqlTracker(ConnectionRollback.create(this.init())), userActions);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
