package ru.job4j.tracker;
import org.hamcrest.Matchers;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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


    /**
     * Тестирование с Mockito
     */

    @Test
    public void deleteMock() throws SQLException {
        Store memTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("new item");
        item = memTracker.add(item);
        DeleteItem action = new DeleteItem();

        Input input = mock(Input.class);
        //when(input.askInt(any(String.class))).thenReturn(Integer.valueOf(item.getId()));
        when(input.askStr(any(String.class))).thenReturn(item.getId());

        action.execute(input, memTracker);
        Item replaced = memTracker.findById(item.getId());
        assertNull(replaced);
    }

    @Test
    public void findByIdMock() throws SQLException {
        Store memTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("new item");
        item = memTracker.add(item);
        Item item2 = new Item("second item");
        item2 = memTracker.add(item2);
        FindByID action = new FindByID();

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getId());

        action.execute(input, memTracker);
        Item replaced = memTracker.findById(item2.getId());
        assertTrue(replaced.getName().equals("second item"));
    }

    @Test
    public void findByNameMock() throws SQLException {
        Store memTracker = new SqlTracker(ConnectionRollback.create(this.init()));
        Item item = new Item("new item");
        item = memTracker.add(item);
        Item item2 = new Item("my item");
        item2 = memTracker.add(item2);
        FindByName action = new FindByName();

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn("my item");

        action.execute(input, memTracker);
        List<Item> replaced = memTracker.findByName("my item");

        Item find = replaced.get(0);
        assertEquals(item2.getId(), find.getId());
        assertFalse(find.getName().equals(item.getName()));
    }

}
