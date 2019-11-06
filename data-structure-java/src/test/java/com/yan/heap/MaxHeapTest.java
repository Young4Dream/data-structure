package com.yan.heap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/5 0005 11:45
 */
@RunWith(JUnit4.class)
public class MaxHeapTest {
    private MaxHeap<Integer> integerMaxHeap;

    @Before
    public void before() {
        int capacity = 100000;
        integerMaxHeap = new MaxHeap<>(capacity);
        Random random = new Random();
        IntStream.range(0, capacity).map(x -> random.nextInt(capacity)).forEach(integerMaxHeap::add);
//        for (int i = 0; i < capacity; i++) {
//            integerMaxHeap.add(random.nextInt(capacity));
//        }
    }

    @Test
    public void test() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        int size = integerMaxHeap.size();
        for (int i = 0; i < size; i++) {
            linkedList.add(integerMaxHeap.extractMax());
        }
        Object[] stream_sort = linkedList.stream().sorted(Comparator.reverseOrder()).toArray();
        Object[] heap_sort = linkedList.toArray();
        Assert.assertArrayEquals(stream_sort, heap_sort);
    }

    @After
    public void after() {

    }
}