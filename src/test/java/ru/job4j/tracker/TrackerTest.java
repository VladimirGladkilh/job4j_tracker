package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void getAllItems() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        tracker.add(new Item("test4"));
        Item[] result = tracker.findAll();
        assertThat(result.length, is(4));
    }

    @Test
    public void findByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);
        tracker.add(new Item("test2"));
        tracker.add(new Item("test3"));
        tracker.add(new Item("test4"));
        tracker.add(new Item("test2"));
        tracker.add(new Item("test5"));
        Item[] result = tracker.findByName("test2");
        assertThat(result.length, is(2));
    }
    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        tracker.add(new Item("Bug2"));
        tracker.add(new Item("Bug2"));
        tracker.add(new Item("Bug3"));
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}