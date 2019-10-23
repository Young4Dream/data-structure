package com.yan.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/18 0018 15:39
 */
@RunWith(JUnit4.class)
public class LinkedListQueueTest {
    private LinkedListQueue<Integer> linkedListQueue;

    @Before
    public void before() {
        linkedListQueue = new LinkedListQueue<>();
    }

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            linkedListQueue.enqueue(i);
            System.out.println(linkedListQueue);
            if (i % 3 == 2) {
                linkedListQueue.dequeue();
                System.out.println(linkedListQueue);
            }
        }
    }

    @After
    public void after() {

    }
}