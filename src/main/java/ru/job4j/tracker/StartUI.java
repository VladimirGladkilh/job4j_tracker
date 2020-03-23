package ru.job4j.tracker;



public class StartUI {
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(input.askStr(""));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name:");
                Item item = new Item(name);
                tracker.add(item);
            } else if (select == 1) {
                System.out.println("=== Show All Items ====");
                Item[] find = tracker.findAll();
                if (find.length == 0) {
                    System.out.println("Items not found");
                } else {
                    System.out.println("Find:");
                    for (Item item: find) {
                        System.out.println(item.getId()+":" + item.getName());
                    }
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");

                String id = input.askStr("=== Enter Item ID ====");
                String newName = input.askStr("=== Enter New Item Name ====");
                Item item = new Item(newName);
                if (tracker.replace(id, item)) {
                    System.out.println("OK. Item replaced. New item is "+ item.getId());
                } else {
                    System.out.println("Error. May bee item with id="+ id + " not found");
                }
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                String id = input.askStr("=== Enter Item ID ====");
                String result = tracker.delete(id) ? "Item's deleted" : "Error delete. May bee item not found";
                System.out.println(result);
            } else if (select == 4) {
                System.out.println("=== Find Item By ID====");
                String id = input.askStr("=== Enter Item ID ====");
                Item find = tracker.findById(id);
                String result = find != null ? "Find item: " + find.getName() : "Item not found";
                System.out.println(result);
            } else if (select == 5) {
                System.out.println("=== Find Item By Name====");
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
            }
            else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
