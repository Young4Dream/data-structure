package com.yan.array.dynamic;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/9/30 0030 16:42
 */
@SuppressWarnings("all")
public class Array<E> extends com.yan.array.generic.Array<E> {
    public Array(int capacity) {
        super(capacity);
    }

    public Array() {
        super();
    }

    public Array(E... es) {
        for (E e : es) {
            super.addLast(e);
        }
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
}
