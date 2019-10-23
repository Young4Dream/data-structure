package com.yan.queue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/17 0017 17:47
 */
@RunWith(JUnit4.class)
public class ComplexityTest {
    @Before
    public void before() {

    }

    private double test_queue(Queue<Integer> q, int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt());
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    @Test
    public void test() {
        int opCount = 100000;
        LoopQueue<Integer> queue = new LoopQueue<>();
        System.out.println("LoopQueue: " + test_queue(queue, opCount));
        ArrayQueue<Integer> integerArrayQueue = new ArrayQueue<>();
        System.out.println("ArrayQueue: " + test_queue(integerArrayQueue, opCount));
        Queue<Integer> linkedListQueue = new LinkedListQueue<>();
        System.out.println("LinkedListQueue: " + test_queue(linkedListQueue, opCount));
    }

    @After
    public void after() {

    }
}