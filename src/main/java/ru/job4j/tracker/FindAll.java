package ru.job4j.tracker;

import java.util.ArrayList;

public class FindAll implements UserAction {
    @Override
    public String name() {
        return "=== Show All Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        ArrayList<Item> find = tracker.findAll();
        if (find.size() == 0) {
            System.out.println("Items not found");
        } else {
            //System.out.println("Find:");
            for (Item item: find) {
                System.out.println(item.getId()+":" + item.getName());
            }
        }
        return true;
    }
}
