package com.yan.array.simple;

import lombok.Data;

import java.util.StringJoiner;

@Data
@SuppressWarnings("all")
public class Array {
    private int[] data;
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
    }

    public Array() {
        this(16);
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
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

    public void add(int index, int element) {
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

    public int get(int index) {
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
    public void set(int index, int element) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index < size!");
        }
        data[index] = element;
    }

    public void addLast(int e) {
        add(size, e);
    }

    public void addFirst(int e) {
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

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Require index >= 0 and index < size!");
        }
        int res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return res;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public boolean removeElement(int element) {
        int index = find(element);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

}
