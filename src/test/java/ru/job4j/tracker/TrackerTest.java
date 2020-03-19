package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
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
}