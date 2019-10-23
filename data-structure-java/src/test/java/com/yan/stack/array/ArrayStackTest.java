package com.yan.stack.array;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/8 0008 11:05
 */
@RunWith(JUnit4.class)
public class ArrayStackTest {
    private ArrayStack<Integer> arrayStack;

    @Before
    public void before() {
        arrayStack = new ArrayStack<>();
    }

    @Test
    public void test() {
        Assert.assertEquals(16, arrayStack.getCapacity());
        Assert.assertTrue(arrayStack.isEmpty());
    }

    @Test
    public void test_peek_empty() {
        Assert.assertNull(arrayStack.peek());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_pop_empty() {
        arrayStack.pop();
    }

    @Test
    public void test_push() {
        arrayStack.push(1);
        Assert.assertEquals(1, (int) arrayStack.peek());
        Assert.assertEquals(1, arrayStack.getSize());
    }

    @Test
    public void test_pop() {
        arrayStack.push(1);
        Assert.assertEquals(1, (int) arrayStack.pop());
        Assert.assertEquals(0, arrayStack.getSize());
    }


    @After
    public void after() {

    }
}