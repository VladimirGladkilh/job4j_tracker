package ru.job4j.tracker;

public class FindByName implements UserAction {
    @Override
    public String name() {
        return "=== Find Item By Name====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("=== Enter Item Name ====");
        Item[] find = tracker.findByName(name);
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
