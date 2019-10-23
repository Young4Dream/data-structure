package com.yan.stack.array;

import com.yan.array.dynamic.Array;
import com.yan.stack.Stack;
import lombok.ToString;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/8 0008 10:39
 */
@ToString
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack() {
        super();
        this.array = new Array<>();
    }

    public ArrayStack(int capacity) {
        super();
        this.array = new Array<>(capacity);
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() throws UnsupportedOperationException {
        E e;
        try {
            e = array.removeLast();
        } catch (IllegalArgumentException e1) {
            throw new UnsupportedOperationException(e1);
        }
        return e;
    }

    @Override
    public E peek() {
        E res;
        try {
            res = array.get(array.getSize() - 1);
        } catch (IllegalArgumentException e) {
            return null;
        }
        return res;
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }
}
