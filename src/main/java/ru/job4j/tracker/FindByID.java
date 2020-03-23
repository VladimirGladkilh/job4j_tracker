package ru.job4j.tracker;

public class FindByID implements UserAction {
    @Override
    public String name() {
        return "=== Find Item By ID====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("=== Enter Item ID ====");
        Item find = tracker.findById(id);
        String result = find != null ? "Find item: " + find.getName() : "Item not found";
        System.out.println(result);
        return true;
    }
}
