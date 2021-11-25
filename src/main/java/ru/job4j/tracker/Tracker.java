package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] allItems = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                allItems[size] = item;
                size++;
            }
        }
        allItems = Arrays.copyOf(allItems, size);
        for (int i = 0; i < allItems.length; i++) {
            System.out.println(allItems[i]);
        }
        return allItems;
    }

    public Item[] findByName(String key) {
        Item[] desiredItem = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                desiredItem[count++] = items[i];
            }
        }
        desiredItem = Arrays.copyOf(desiredItem, size);
        return desiredItem;
    }
}