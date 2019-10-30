package com.yan.set;

import com.yan.linked.recursion.LinkedList;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/30 0030 16:14
 */
public class LinkedListSet<E> implements Set<E> {
    private LinkedList<E> linkedList;

    public LinkedListSet() {
        linkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (linkedList.contains(e)) {
            return;
        }
        linkedList.addFirst(e);
    }

    @Override
    public void remove(E e) {
        linkedList.removeElement(e);
    }

    @Override
    public int size() {
        return linkedList.size();
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }
}
