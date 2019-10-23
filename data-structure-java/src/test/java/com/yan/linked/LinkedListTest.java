package com.yan.linked;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/18 0018 10:55
 */
@RunWith(JUnit4.class)
public class LinkedListTest {
    private LinkedList<Integer> linkedList = new LinkedList<>();

    @Before
    public void before() {
        linkedList.add(0);
        linkedList.add(1);
    }

    @Test
    public void test() {
        Assert.assertEquals(2, linkedList.size());
        Assert.assertEquals(0, linkedList.get(0), 0);
        Assert.assertTrue(linkedList.contains(0));
    }

    @Test
    public void test_remove() {
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove(2);
        System.out.println(linkedList);
    }


    @After
    public void after() {

    }
}