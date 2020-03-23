package ru.job4j.tracker;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        CreateAction action = new CreateAction();
        action.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        EditItem action = new EditItem();
        StubInput input = new StubInput(
                answers
        );
        action.execute(input, tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }
    @Test
    public void  whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        DeleteItem action = new DeleteItem();
        StubInput input = new StubInput(
                new String[] {item.getId()}
        );
        action.execute(input, tracker);
        Item replaced = tracker.findById(item.getId());
        assertNull(replaced);
    }
    @Test
    public void whenExit() {
        StubInput input = new StubInput(
                new String[] {"0"}
        );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        assertThat(action.isCall(), is(true));
    }
}
