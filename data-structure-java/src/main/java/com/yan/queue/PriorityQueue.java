package com.yan.queue;

import com.yan.heap.BiHeap;

import java.util.Comparator;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/7 0007 16:17
 */
@SuppressWarnings("all")
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private BiHeap<E> biHeap;
    public PriorityQueue() {
        super();
        biHeap = new BiHeap<>();
    }

    public PriorityQueue(Comparator<E> comparator) {
        super();
        biHeap = new BiHeap<>(comparator);
    }

    @Override
    public int getSize() {
        return biHeap.size();
    }

    @Override
    public void enqueue(E e) {
        biHeap.put(e);
    }

    @Override
    public E dequeue() {
        return biHeap.pop();
    }

    @Override
    public E getFront() {
        return biHeap.peek();
    }
}
