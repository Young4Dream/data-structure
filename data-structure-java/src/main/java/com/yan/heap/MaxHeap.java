package com.yan.heap;

import com.yan.array.dynamic.Array;

import java.util.Comparator;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/5 0005 09:40
 */
@SuppressWarnings("all")
public class MaxHeap<E extends Comparable<E>> implements Cloneable {
    private Array<E> data;
    private Comparator<E> comparator = E::compareTo;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(Comparator<E> comparator) {
        this();
        if (null != comparator) {
            this.comparator = comparator;
        }
    }

    // heapify
    public MaxHeap(E... es) {
        this(null, es);
    }

    // heapify
    public MaxHeap(Comparator<E> comparator, E... es) {
        this(comparator);
        data = new Array<>(es);
        for (int i = parent(size() - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    protected Object[] getData() {
        return this.data.getData();
    }

    @Override
    protected MaxHeap<E> clone() throws CloneNotSupportedException {
        MaxHeap<E> clone = (MaxHeap<E>) super.clone();
        clone.data = this.data.clone();
        return clone;
    }

    public int size() {
        return data.getSize();
    }

    public E replace(E e) {
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("");
        }
        return (index - 1) / 2;
    }

    private E get(int i) {
        return data.get(i);
    }

    private int left(int index) {
        return 2 * index + 1;
    }

    private int right(int index) {
        return left(index) + 1;
    }

    /**
     * 添加元素，来着不拒
     *
     * @param e 待添加元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(size() - 1);
    }


    /**
     * 添加元素，已经存在则忽略
     *
     * @param e 待添加元素
     */
    public void put(E e) {
        if (data.contains(e)) {
            return;
        }
        add(e);
    }

    private void siftUp(int i) {
        if (i == 0) return;
        int parent = parent(i);
        if (comparator.compare(data.get(parent), data.get(i)) > 0) {
            return;
        }
        data.swap(i, parent);
        siftUp(parent);
    }

    public E findMax() {
        if (data.getSize() <= 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    public E extractMax() {
        E res = findMax();
        data.swap(0, size() - 1);
        data.removeLast();
        siftDown(0);
        return res;
    }

    private boolean hasLeft(int i) {
        return left(i) < size();
    }

    private boolean hasRight(int i) {
        return right(i) < size();
    }

    private boolean hasChild(int i) {
        return hasLeft(i);
    }

    private int maxChild(int index) {
        if (!hasChild(index)) {
            throw new IllegalArgumentException("Can not find Max Child when no children.");
        }
        int max = left(index);

        if (hasRight(index) && comparator.compare(get(right(index)), get(max)) > 0) {
            max = right(index);
        }
        return max;
    }

    private void siftDown(int index) {
        while (hasChild(index)) {
            int max = maxChild(index);
            if (comparator.compare(get(max), get(index)) <= 0) {
                break;
            }
            data.swap(max, index);
            index = max;
        }
    }

}
