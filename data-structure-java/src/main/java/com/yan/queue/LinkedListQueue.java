package com.yan.queue;

import java.util.StringJoiner;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/18 0018 13:38
 */
public class LinkedListQueue<E> implements Queue<E> {
    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        Node tail = new Node(e);
        if (this.tail == null) {
            this.tail = tail;
            head = this.tail;
        } else {
            this.tail = this.tail.next = tail;
        }
        size++;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", LinkedListQueue.class.getSimpleName() + "[", "]");
        return stringJoiner
                .add("elements=" + elements())
                .add("size=" + size)
                .toString();
    }

    private String elements() {
        if (null == head) {
            return "[]";
        }
        StringJoiner eleJoiner = new StringJoiner(", ", "[", "]");
        eleJoiner.add(String.valueOf(head.e));
        Node cur = head.next;
        while (cur != null) {
            eleJoiner.add(String.valueOf(cur.e));
            cur = cur.next;
        }
        return eleJoiner.toString();
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Require non-empty queue!");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null; // help GC
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    private class Node {
        E e;
        Node next;

        Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        Node(E e) {
            this(e, null);
        }

        public E getE() {
            return e;
        }

        public void setE(E e) {
            this.e = e;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
