package com.yan.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Comparator;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/7 0007 17:53
 */
@RunWith(JUnit4.class)
public class PriorityQueueTest {
    private PriorityQueue<Integer> priorityQueue;

    @Before
    public void before() {
        priorityQueue = new PriorityQueue<>();
    }

    @Test
    public void test() {
        for (int i = 10; i >= 0; i--) {
            priorityQueue.enqueue(i);
        }
        for (int i = 10; i >= 0; i--) {
            System.out.println(priorityQueue.dequeue());
        }
    }

    @Test
    public void test_reverse_order() {
        Comparator<Integer> integerComparator = Comparator.reverseOrder();
        priorityQueue = new PriorityQueue<>(integerComparator);
        for (int i = 10; i >= 0; i--) {
            priorityQueue.enqueue(i);
        }
        for (int i = 10; i >= 0; i--) {
            System.out.println(priorityQueue.dequeue());
        }
    }


    @After
    public void after() {

    }
}