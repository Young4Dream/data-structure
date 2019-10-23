package com.yan.array.simple;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayTest {
    private Array array;

    @Before
    public void before() {
        array = new Array(1);
    }

    @Test
    public void test_addFirst() {
        array.addFirst(1);
        Assert.assertEquals(1, array.get(0));
        Assert.assertEquals(1, array.getSize());
        Assert.assertFalse(array.isEmpty());
        Assert.assertThat(new int[]{1}, Is.is(array.getData()));
        String assert_to_string = "Array: size = 1, capacity = 1 \n" +
                "[1]";
        Assert.assertEquals(assert_to_string, array.toString());
    }

    @Test
    public void test_default_capacity() {
        array = new Array();
        Assert.assertEquals(16, array.getCapacity());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_unsupported_operation() {
        array.addFirst(1);
        array.addFirst(1);
    }

    @Test
    public void test_contains() {
        array.addLast(1);
        boolean contains = array.contains(1);
        assert contains;
    }

    @Test
    public void test_not_contains() {
        Assert.assertFalse(array.contains(1));
    }


    @Test
    public void test_find() {
        array.addLast(1);
        int i = array.find(1);
        Assert.assertEquals(0, i);
    }

    @Test
    public void test_not_found() {
        Assert.assertEquals(-1, array.find(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_illegal_argument() {
        array.add(1, 9);
    }

    @Test
    public void test_update() {
        array.addLast(1);
        array.set(0, 9);
        Assert.assertEquals(9, array.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_test_test_illegal_argument_when_set() {
        array.set(-1, 9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_test_test_illegal_argument_when_get() {
        array.get(-1);
    }

    @Test
    public void test_remove() {
        array = new Array(6);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        array.addLast(5);
        array.addLast(6);
        array.remove(0);
        Assert.assertThat(new int[]{2, 3, 4, 5, 6, 6}, Is.is(array.getData()));
        array.removeElement(3);
        Assert.assertThat(new int[]{2, 4, 5, 6, 6, 6}, Is.is(array.getData()));
        array.removeFirst();
        Assert.assertThat(new int[]{4, 5, 6, 6, 6, 6}, Is.is(array.getData()));
        array.removeLast();
        Assert.assertThat(new int[]{4, 5, 6, 6, 6, 6}, Is.is(array.getData()));
    }


    @After
    public void after() {

    }
}
