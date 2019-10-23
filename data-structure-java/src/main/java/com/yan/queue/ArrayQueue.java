package com.yan.queue;

import com.yan.array.dynamic.Array;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/8 0008 13:51
 */
public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue() {
        super();
        array = new Array<>();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public E getFront() {
        return array.get(0);
    }
}
