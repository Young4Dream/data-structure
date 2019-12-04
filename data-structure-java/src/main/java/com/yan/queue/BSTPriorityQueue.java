package com.yan.queue;

import com.yan.tree.BST;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/7 0007 16:17
 */
public class BSTPriorityQueue<E extends Comparable<E>> implements Queue<E> {
    private BST<E> bst;

    public BSTPriorityQueue() {
        super();
        bst = new BST<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public void enqueue(E e) {
        bst.add(e);
    }

    @Override
    public E dequeue() {
        return bst.removeMax();
    }

    @Override
    public E getFront() {
        return bst.findMax();
    }
}
