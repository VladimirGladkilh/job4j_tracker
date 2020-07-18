package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        Item result = memTracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void getAllItems() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        memTracker.add(new Item("test2"));
        memTracker.add(new Item("test3"));
        memTracker.add(new Item("test4"));
        List<Item> result = memTracker.findAll();
        assertThat(result.size(), is(4));
    }

    @Test
    public void findByName() {
        MemTracker memTracker = new MemTracker();
        Item item = new Item("test1");
        memTracker.add(item);
        memTracker.add(new Item("test2"));
        memTracker.add(new Item("test3"));
        memTracker.add(new Item("test4"));
        memTracker.add(new Item("test2"));
        memTracker.add(new Item("test5"));
        List<Item> result = memTracker.findByName("test2");
        assertThat(result.size(), is(2));
    }
    @Test
    public void whenReplace() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        memTracker.replace(id, bugWithDesc);
        assertThat(memTracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker memTracker = new MemTracker();
        Item bug = new Item("Bug");
        memTracker.add(bug);
        memTracker.add(new Item("Bug2"));
        memTracker.add(new Item("Bug2"));
        memTracker.add(new Item("Bug3"));
        String id = bug.getId();
        memTracker.delete(id);
        assertThat(memTracker.findById(id), is(nullValue()));
    }
}