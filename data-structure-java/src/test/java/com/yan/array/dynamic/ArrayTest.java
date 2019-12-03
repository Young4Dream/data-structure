package com.yan.array.dynamic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ArrayTest {
    private Array<String> array;

    @Before
    public void setUp() throws Exception {
        array = new Array<>("Hello", "World", "!");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testAdd() {
        assertEquals(array.getSize(), 3);
        array.addFirst(" ");
        array.addLast("!!");
        assertEquals(array.getSize(), 5);
    }

    @Test
    public void testRemove() {
        array.removeLast();
        String[] strings = {"Hello", "World", null};
        assertArrayEquals(strings, array.toArray());
    }

    @Test
    public void test_resize() {
        array.add(1, "");
        array.addLast("");
        array.addLast("");
        array.addLast("");
        array.addLast("");
        array.addLast("");
        array.addLast("");
        array.removeLast();
        array.remove(0);
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        array.removeFirst();
        assertEquals(1, array.getSize());
    }
}