package com.yan.linked.recursion;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/23 0023 11:45
 */
@RunWith(JUnit4.class)
public class LinkedListTest {
    private LinkedList<Integer> linkedList;

    @Before
    public void before() {
        linkedList = new LinkedList<>();
        linkedList.add(0);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
    }

    @Test
    public void test() {
        Assert.assertEquals(linkedList.size(), 4);
        Assert.assertEquals(linkedList.get(3), 3, 1);
    }

    @Test
    public void test_remove() {
        linkedList.remove(0);
        linkedList.remove(2);
        Assert.assertTrue(linkedList.contains(3));
        Assert.assertFalse(linkedList.contains(0));
        linkedList.remove(1);
        Assert.assertEquals(linkedList.size(), 1);
        linkedList.remove(0);
    }

    @Test
    public void test_remove_element() {
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.removeElement(4);
        Assert.assertEquals(linkedList.size(), 5);
    }

    @Test
    public void test_update() {
        linkedList.update(2, 6);
        Assert.assertEquals(linkedList.get(2), 6, 0);
    }

    @Test
    public void test_insert() {
        linkedList.insert(0, 9);
        Assert.assertEquals(9, linkedList.getFirst(), 0);

        linkedList.insert(2, 7);
        Assert.assertEquals(7, linkedList.get(2), 0);
        Assert.assertEquals(6, linkedList.size());
    }


    @After
    public void after() {
        linkedList = null;
    }
}