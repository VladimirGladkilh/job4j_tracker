package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MemTracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    //private int position = 0;

    /**
     * Метод реализующий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private Integer generateId() {
        Random rm = new Random();
        return Math.toIntExact((rm.nextLong() + System.currentTimeMillis()));
    }
    public List<Item> findAll() {
        return items;
    }
    public List<Item> findByName(String key) {
        List<Item> itemsByName = new ArrayList<>();
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index) != null && items.get(index).getName().equals(key)) {
                itemsByName.add(items.get(index));
            }
        }
        return itemsByName;
    }
    public Item findById(Integer id) {
        // Находим индекс
        int index = indexOf(id);
        // Если индекс найден возвращаем item, иначе null
        return index != -1 ? items.get(index) : null;
    }

    private int indexOf(Integer id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(Integer id, Item item) {
        int index = indexOf(id);
        if (index > -1) {
            item.setId(id);
            items.set(index, item);
        }
        return index > -1;
    }
    public boolean delete(Integer id) {
        int index = indexOf(id);
        if (index > -1) {
            items.remove(index);
            return true;
        } else {
            return false;
        }
    }
}