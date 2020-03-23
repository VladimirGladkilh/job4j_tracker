package ru.job4j.tracker;

public class FindAll implements UserAction {
    @Override
    public String name() {
        return "=== Show All Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] find = tracker.findAll();
        if (find.length == 0) {
            System.out.println("Items not found");
        } else {
            System.out.println("Find:");
            for (Item item: find) {
                System.out.println(item.getId()+":" + item.getName());
            }
        }
        return true;
    }
}
