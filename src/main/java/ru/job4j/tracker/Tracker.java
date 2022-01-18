package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.set(index, item);
        }
        return result;
    }

    public boolean delete(int id) {

        int index = indexOf(id);
        boolean result = index != -1;
        if (result) {
            items.remove(index);
        }
        return result;
    }

    private int indexOf(int id) {
        int rsl = items.indexOf(items.get(id - 1));
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(id - 1) : null;
    }

    public Item[] findAll() {
        return items.toArray(new Item[0]);
    }

    public  List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(key)) {
                result.add(items.get(i));
            }
        }
        return result;
    }
}