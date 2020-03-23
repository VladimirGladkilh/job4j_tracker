package ru.job4j.tracker;

public class DeleteItem implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("=== Enter Item ID ====");
        String result = tracker.delete(id) ? "Item's deleted" : "Error delete. May bee item not found";
        System.out.println(result);
        return true;
    }
}
