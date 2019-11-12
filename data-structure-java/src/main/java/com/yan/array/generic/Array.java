package com.yan.array.generic;

import java.util.StringJoiner;

@SuppressWarnings("all")
public class Array<T> {
    protected T[] data;
    protected int size;

    public T[] getData() {
        return data;
    }

    public int getSize() {
        return size;
    }

    public Array(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(16);
    }

    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            T datum = data[i];
            if (null == datum) {
                return null == e;
            }
            if (datum.equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public int getCapacity() {
        return getData().length;
    }

    public void add(int index, T element) {
        if (size == data.length) {
            throw new UnsupportedOperationException("Add failed. Array is FULL!");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size!");
        }
        for (int i = size - 1; i >= index; i--) data[i + 1] = data[i];
        data[index] = element;
        size++;
    }

    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Require index >= 0 and index < size!");
        }
        return data[index];
    }

    /**
     * 修改某个位置的元素
     *
     * @param index   索引
     * @param element 想要赋值的对象
     */
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Update failed. Require index >= 0 and index < size!");
        }
        data[index] = element;
    }

    public void addLast(T e) {
        add(size, e);
    }

    public void addFirst(T e) {
        add(0, e);
    }

    @Override
    public String toString() {
        String format = String.format("Array: size = %d, capacity = %d \n[", size, data.length);
        StringJoiner stringJoiner = new StringJoiner(",", format, "]");
        for (int i = 0; i < size; i++) {
            stringJoiner.add(String.valueOf(data[i]));
        }
        return stringJoiner.toString();
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size!");
        }
        T res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return res;
    }

    public void swap(int i, int j) {
        T t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public T removeFirst() {
        return remove(0);
    }

    public T removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(T element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

}
