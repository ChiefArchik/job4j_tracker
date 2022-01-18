package ru.job4j.tracker;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new SubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new CreateAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenEditItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Edit item"));
        String editedName = "New Item name";
        Input in = new SubInput(
                new String[] {"0", String.valueOf(item.getId()), editedName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new EditAction(output),
                new ExitAction()
        );
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(editedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Item item1 = tracker.add(new Item("Item"));
        Input in = new SubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new DeleteAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is("Item"));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new SubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                       + "0. Exit" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new SubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new EditAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                + "0. Edit Item" + ln
                + "1. Exit" + ln
                + "=== Edit Item ===" + ln
                + "Заявка измененна успешно." + ln
                + "Menu:" + ln
                + "0. Edit Item" + ln
                + "1. Exit" + ln
        ));
    }

    @Test
    public void whenShaowAllItemsTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        Input in = new SubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new ShowAllAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
                        + "=== Show all Items ===" + ln
                        + one + ln
                        + "Menu:" + ln
                        + "0. Show all Items" + ln
                        + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindItemByIdTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        Input in = new SubInput(
                new String[] {"0", String.valueOf(one.getId()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindByIdAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                + "0. Find Item by id" + ln
                + "1. Exit" + ln
                + "=== Find Item by id ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Find Item by id" + ln
                + "1. Exit" + ln
        ));
    }

    @Test
    public void whenFindItemByNameTestOutputIsSuccessfully() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test"));
        Input in = new SubInput(
                new String[] {"0", String.valueOf(one.getName()), "1"}
        );
        List<UserAction> actions = Arrays.asList(
                new FindByNameAction(out),
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                + "0. Find Item by name" + ln
                + "1. Exit" + ln
                + "=== Find Item by name ===" + ln
                + one + ln
                + "Menu:" + ln
                + "0. Find Item by name" + ln
                + "1. Exit" + ln
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new SubInput(
                new String[] {"9", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = Arrays.asList(
                new ExitAction()
        );
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                + "0. Exit" + ln
                + "Wrong input, you can select: 0 .. 0" + ln
                + "Menu:" + ln
                + "0. Exit" + ln
        )
        );
    }
}