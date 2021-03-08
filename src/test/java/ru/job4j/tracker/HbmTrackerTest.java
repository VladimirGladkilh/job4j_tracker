package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class HbmTrackerTest {


    @Test
    public void add() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("ItemName");
        hbmTracker.add(item);
        List<Item> all = hbmTracker.findAll();
        assertEquals(item, all.get(0));
    }

    @Test
    public void replace() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = hbmTracker.add(new Item("ItemName"));
        item.setDescription("MyDescription");
        item.setName("newName");
        hbmTracker.replace(item.getId(), item);
        assertThat(hbmTracker.findByName("ItemName").size(), is(0));
        assertThat(hbmTracker.findByName("newName").size(), is(1));
    }

    @Test
    public void delete() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = hbmTracker.add(new Item("ItemName"));
        hbmTracker.delete(item.getId());
        assertThat(hbmTracker.findByName("ItemName").size(), is(0));
    }

    @Test
    public void findAll() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("ItemName");
        Item item2 = new Item("AnotherItem");
        hbmTracker.add(item);
        hbmTracker.add(item2);
        assertEquals(List.of(item, item2), hbmTracker.findAll());
    }

    @Test
    public void findByName() {
        HbmTracker hbmTracker = new HbmTracker();
        hbmTracker.add(new Item("ItemName"));
        hbmTracker.add(new Item("AnotherItem"));
        assertEquals("AnotherItem", hbmTracker.findByName("AnotherItem").get(0).getName());
    }

    @Test
    public void findById() {
        HbmTracker hbmTracker = new HbmTracker();
        Item item = new Item("ItemName");
        item.setId(1);
        item.setDescription("Description1");
        Item item2 = new Item("AnotherItem");
        item2.setId(2);
        item2.setDescription("Description2");
        hbmTracker.add(item);
        hbmTracker.add(item2);
        assertEquals("ItemName", hbmTracker.findById(1).getName());
    }
}