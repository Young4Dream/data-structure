package com.yan.queue;

import com.yan.heap.MaxHeap;

import java.util.Comparator;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/7 0007 16:17
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        super();
        maxHeap = new MaxHeap<>();
    }

    public PriorityQueue(Comparator<E> comparator) {
        super();
        maxHeap = new MaxHeap<>(comparator);
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
