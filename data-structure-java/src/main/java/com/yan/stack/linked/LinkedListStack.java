package com.yan.stack.linked;

import com.yan.linked.LinkedList;
import com.yan.stack.Stack;

import java.util.StringJoiner;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/18 0018 12:14
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList<E> linkedList;

    public LinkedListStack() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() throws UnsupportedOperationException {
        E e = linkedList.getFirst();
        linkedList.removeFirst();
        return e;
    }

    @Override
    public E peek() {
        return linkedList.get(0);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LinkedListStack.class.getSimpleName() + "[", "]")
                .add(linkedList.toString())
                .toString();
    }

    @Override
    public int getSize() {
        return linkedList.size();
    }
}
