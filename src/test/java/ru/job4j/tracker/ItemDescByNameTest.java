package ru.job4j.tracker;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemDescByNameTest extends TestCase {

    public void testCompare() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        List<Item> items = new ArrayList<>();
        Item item1 = new Item("1 item", 1);
        items.add(item1);
        Item item2 = new Item("5 item", 2);
        items.add(item2);
        Item item3 = new Item("3 item", 3);
        items.add(item3);
        List<Item> expected = Arrays.asList(item2, item3, item1);
        Collections.sort(items, Collections.reverseOrder());
        assertThat(items, is(expected));
    }
}