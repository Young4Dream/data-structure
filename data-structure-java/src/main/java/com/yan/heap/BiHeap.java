package com.yan.heap;

import com.yan.array.dynamic.Array;
import com.yan.tree.BST;

import java.util.Comparator;
import java.util.Objects;

/**
 * 二叉堆
 * <p>
 * 1. 除叶子节点外为满二叉树
 * 2. 是完全二叉树，叶子节点统一靠左，因此可以使用数组表示，这里使用动态数组
 * 3. 按层级添加元素，因此不会像二分搜索树一样可能退化为链表
 *
 * @see BST
 * @see Array
 */
public class BiHeap<E extends Comparable<E>> {
    private Array<E> array;
    private Comparator<? super E> comparator;

    @SuppressWarnings("all")
    public BiHeap() {
        array = new Array<>();
        comparator = E::compareTo;
    }

    @SuppressWarnings("all")
    public BiHeap(Comparator<? super E> comparator) {
        this();
        if (comparator != null) {
            this.comparator = comparator;
        }
    }

    @SuppressWarnings("all")
    public BiHeap(Comparator<? super E> comparator, E... es) {
        this(comparator);
        if (es != null) {
            array = new Array<>(es).removeIf(Objects::isNull);
        }
        for (int i = 0; i < array.getSize(); i++) {
            sift_down(i);
        }
    }

    public E put(E e) {
        if (null == e) return null;
        array.addLast(e);
        sift_up(array.getSize() - 1);
        return e;
    }

    public E pop() {
        E e = array.get(0);
        swap(0, array.getSize() - 1);
        array.removeLast();
        sift_down(0);
        return e;
    }

    public E peek() {
        return array.isEmpty() ? null : array.get(0);
    }

    private int parent_index(int i) {
        return Math.max(0, (i - 1) >> 1);
    }

    private int left_index(int i) {
        return Math.min(array.getSize() - 1, (i << 1) + 1);
    }

    private int right_index(int i) {
        return Math.min(array.getSize() - 1, (left_index(i)) + 1);
    }

    private void swap(int l, int r) {
        E t = array.get(l);
        array.set(l, array.get(r));
        array.set(r, t);
    }

    private void sift_up(int i) {
        if (i == 0) {
            return;
        }
        int parent_index = parent_index(i);
        E parent = array.get(parent_index);
        E current = array.get(i);
        if (comparator.compare(current, parent) > 0) swap(i, parent_index);
        sift_up(parent_index);
    }

    private void sift_down(int i) {
        if (i == array.getSize() - 1) return;
        int priority_child_index = find_priority_child_index(i);
        E max_child = array.get(priority_child_index);
        E current = array.get(i);
        if (comparator.compare(current, max_child) < 0)
            swap(i, priority_child_index);
        sift_down(priority_child_index);
    }

    private int find_priority_child_index(int i) {
        int left_index = left_index(i);
        int right_index = right_index(i);
        if (left_index == right_index) {
            return left_index;
        }
        E left = array.get(left_index);
        E right = array.get(right_index);
        return comparator.compare(left, right) > 0 ? left_index : right_index;
    }
}
