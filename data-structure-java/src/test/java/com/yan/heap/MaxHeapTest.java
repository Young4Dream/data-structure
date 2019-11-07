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

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/5 0005 11:45
 */
@RunWith(JUnit4.class)
public class MaxHeapTest {
    private static final int CAPACITY = 100000;
    private Object[] stream_sort;
    private MaxHeap<Integer> integerMaxHeap;
    private LinkedList<Integer> random_list;

    @Before
    public void before() {
        random_list = new LinkedList<>();
        integerMaxHeap = new MaxHeap<>(CAPACITY);
        Random random = new Random();
        for (int x = 0; x < CAPACITY; x++) {
            int nextInt = random.nextInt(CAPACITY);
            random_list.add(nextInt);
            integerMaxHeap.add(nextInt);
        }
        stream_sort = random_list.stream().sorted(Comparator.reverseOrder()).toArray();
    }

    @Test
    public void test() {
        LinkedList<Integer> heap_sort = new LinkedList<>();
        int size = integerMaxHeap.size();
        for (int i = 0; i < size; i++) {
            heap_sort.add(integerMaxHeap.extractMax());
        }
        Assert.assertArrayEquals(stream_sort, heap_sort.toArray());
    }

    @Test
    public void test_heapify() {
        Integer[] random_data = random_list.toArray(new Integer[0]);
        MaxHeap<Integer> integerMaxHeap = new MaxHeap<>(random_data);

        Object[] sort_data = new Object[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            sort_data[i] = integerMaxHeap.extractMax();
        }
        Object[] sort_data1 = new Object[CAPACITY];
        for (int i = 0; i < CAPACITY; i++) {
            sort_data1[i] = this.integerMaxHeap.extractMax();
        }
        Assert.assertArrayEquals(sort_data, sort_data1);
    }

    @After
    public void after() {

    }
}