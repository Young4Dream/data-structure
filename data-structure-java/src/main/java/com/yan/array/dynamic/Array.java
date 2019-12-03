package com.yan.array.dynamic;

import java.util.Iterator;
import java.util.function.Predicate;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/9/30 0030 16:42
 */
@SuppressWarnings("all")
public class Array<E> extends com.yan.array.generic.Array<E> implements Cloneable, Iterable<E> {

    public Array(int capacity) {
        super(capacity);
    }

    public Array() {
        super();
    }

    public Array(E... es) {
        data = es;
        size = es.length;
    }

    public E[] toArray() {
        return data;
    }

    @Override
    public Array<E> clone() throws CloneNotSupportedException {
        Array<E> clone = (Array<E>) super.clone();
        clone.data = this.data.clone();
        clone.size = Integer.valueOf(size);
        return clone;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size!");
        }
        if (size == data.length) {
            resize(size << 1);
        }
        for (int i = size - 1; i >= index; i--) data[i + 1] = data[i];
        data[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size!");
        }
        E res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;
        if (size == data.length >> 2)
            resize(data.length >> 1);
        return res;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++)
            newData[i] = data[i];
        data = newData;
    }

    public Array<E> removeIf(Predicate<E> predicate) {
        for (int i = 0; i < data.length; i++) {
            E datum = data[i];
            if (predicate.test(datum)) {
                remove(i);
            }
        }
        return this;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < getSize();
            }

            @Override
            public E next() {
                return get(index++);
            }
        };
    }
}
