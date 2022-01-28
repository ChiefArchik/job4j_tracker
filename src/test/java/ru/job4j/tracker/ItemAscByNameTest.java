package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemAscByNameTest {

    @Test
    public void itemDescByName() {
        List<Item> items;
        Item cooper = new Item(1, "Cooper");
        Item mann = new Item(4, "Mann");
        Item brand = new Item(3, "Brand");
        Item merph = new Item(2, "Merph");
        items = Arrays.asList(cooper, mann, brand, merph);
        Collections.sort(items, new ItemAscByName());
        List<Item> expected;
        expected = Arrays.asList(brand, cooper, mann, merph);
        assertThat(items, is(expected));
    }
}