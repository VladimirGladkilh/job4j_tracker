package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final ArrayList<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        //this.items.set(position, item);
        position++;
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
    public ArrayList<Item> findAll() {
        /*Item[] itemsWithoutNull = new Item[position];
        int size = 0;
        for (int index = 0; index < position; index++) {
            if (items[index] != null) {
                itemsWithoutNull[size] = items[index];
                size++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, size);*/
        //return Arrays.copyOf(items, position);
        return items;
    }
    public ArrayList<Item> findByName(String key) {
        ArrayList<Item> itemsByName = new ArrayList<>();
        for (int index = 0; index < position; index++) {
            if (items.get(index) != null && items.get(index).getName().equals(key)) {
                itemsByName.add(items.get(index));
            }
        }
        return itemsByName;
    }
    public Item findById(String id) {
        // Находим индекс
        int index = indexOf(id);
        // Если индекс найден возвращаем item, иначе null
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        if (index > -1) {
            item.setId(id);
            items.set(index, item);
        }
        return index > -1;
    }
    public boolean delete(String id) {
        int index = indexOf(id);
        if (index > -1) {
            items.remove(index);
            /*int start = index + 1;
            int size = position - index;
            System.arraycopy(items, start, items, start - 1, size);
            items[position - 1] = null;
            position--;*/
            return true;
        } else {
            return false;
        }
    }
}