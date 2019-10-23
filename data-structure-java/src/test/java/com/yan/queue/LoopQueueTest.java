package com.yan.queue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.lang.reflect.Field;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/8 0008 15:49
 */
@RunWith(JUnit4.class)
public class LoopQueueTest {
    private LoopQueue<Integer> loopQueue;

    @Before
    public void before() {
        loopQueue = new LoopQueue<>(8);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test() {
        loopQueue.enqueue(1);
        loopQueue.dequeue();
        loopQueue.enqueue(2);
        loopQueue.enqueue(3);
        loopQueue.enqueue(4);
        loopQueue.enqueue(5);
        loopQueue.enqueue(6);
        loopQueue.enqueue(7);
        loopQueue.dequeue();
        loopQueue.enqueue(8);
        loopQueue.enqueue(9);
        loopQueue.enqueue(10);
        Assert.assertEquals(16, loopQueue.getCapacity());
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        Assert.assertEquals(8, loopQueue.getCapacity());
        loopQueue.dequeue();
        loopQueue.dequeue();
        Assert.assertEquals(4, loopQueue.getCapacity());
        loopQueue.dequeue();
        Assert.assertEquals(2, loopQueue.getCapacity());
        loopQueue.dequeue();
        loopQueue.dequeue();
        System.out.println(loopQueue);
    }

    @Test
    public void test_with_capacity() {
        int capacity = 10;
        LoopQueue<Integer> queue = new LoopQueue<>(capacity);
        for (int i = 0; i < capacity; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

    /**
     * 表明空间是充分利用的
     *
     * @throws NoSuchFieldException   找不到属性
     * @throws IllegalAccessException 反射错误
     */
    @Test
    public void test_tail_lt_front() throws NoSuchFieldException, IllegalAccessException {
        LoopQueue<Integer> queue = new LoopQueue<>(8);
        queue.enqueue(1);
        queue.dequeue();
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(8);
        queue.enqueue(9);
        queue.enqueue(10);
        Field tailField = LoopQueue.class.getDeclaredField("tail");
        tailField.setAccessible(true);
        int tail = (Integer) tailField.get(queue);
        Field frontField = LoopQueue.class.getDeclaredField("front");
        frontField.setAccessible(true);
        int front = (Integer) frontField.get(queue);
        Assert.assertTrue(tail < front);
    }


    @After
    public void after() {

    }
}