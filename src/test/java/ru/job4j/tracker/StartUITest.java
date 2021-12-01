package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new SubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenEditItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("New Item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), "Edited Item"
        };
        StartUI.editItem(new SubInput(answers), tracker);
        Item edited = tracker.findById(item.getId());
        assertThat(edited.getName(), is("Edited Item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId())
        };
        StartUI.deleteItem(new SubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        Item expected = null;
        assertThat(deleted, is(expected));
    }
}