package com.yan.linked;

import com.yan.collection.Collection;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/22 0022 10:38
 */
@SuppressWarnings("all")
public abstract class AbstractLinkedList<E> implements Collection<E> {
    protected int size;
    protected Node head;

    protected abstract void insert(int index, E e);

    public void addLast(E e) {
        insert(size, e);
    }

    public void addFirst(E e) {
        insert(0, e);
    }

    @Override
    public int size() {
        return size;
    }

    protected class Node {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return String.valueOf(e);
        }
    }
}
