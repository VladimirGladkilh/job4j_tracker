package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemComporatorTest {
    @Test
    public void sort() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("Second"));
        itemList.add(new Item("First"));
        itemList.add(new Item("Third"));
        Collections.sort(itemList);
        assertThat(itemList.get(0).getName(), is("First"));
    }

    @Test
    public void sortDesc() {
        List<Item> itemList = new ArrayList<>();
        itemList.add(new Item("First"));
        itemList.add(new Item("Third"));
        itemList.add(new Item("Second"));
        Collections.sort(itemList, new ItemComporatorDesc());
        assertThat(itemList.get(0).getName(), is("Third"));
    }
}
