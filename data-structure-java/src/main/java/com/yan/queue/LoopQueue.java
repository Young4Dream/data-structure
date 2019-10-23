package com.yan.queue;

import java.util.StringJoiner;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/14 0014 11:30
 */
@SuppressWarnings("all")
public class LoopQueue<E> implements Queue<E> {
    private int front, tail;
    private E[] data;

    public LoopQueue() {
        this(16);
    }

    public LoopQueue(int capacity) {
        front = tail = -1;
        data = (E[]) new Object[capacity];
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", LoopQueue.class.getSimpleName() + "{", "}")
                .add("front=" + front)
                .add("tail=" + tail)
                .add("capacity=" + getCapacity())
                .add("data=" + dataString())
                .toString();
    }

    public int getCapacity() {
        return data.length;
    }

    private String dataString() {
        if (isEmpty()) {
            return "[]";
        }
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        for (int i = 0; i < (tail >= front ? front + getSize() : getCapacity()); i++) {
            stringJoiner.add(String.valueOf(data[i]));
        }
        return stringJoiner.toString();
    }

    @Override
    public int getSize() {
        if (front == -1) {
            return 0;
        }
        int size = tail - front + 1;
        if (size > 0) {
            return size;
        }
        return size + getCapacity();
    }

    @Override
    public void enqueue(E e) {
        if (isEmpty()) {
            front = 0;
        }
        tail = (tail + 1) % getCapacity();
        data[tail] = e;
        if (getSize() == getCapacity()) {
            resize(getCapacity() << 1);
        }
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new UnsupportedOperationException("Dequeue fail! Require non-empty queue.");
        }
        E datum = data[front];
        data[front] = null;
        if (getSize() == 1) {
            // 如果此时出队，队列肯定为空了，此时安全重置头尾指针
            front = tail = -1;
        } else {
            front = (front + 1) % getCapacity();
            if (getSize() == getCapacity() >> 2 && (getCapacity() >> 1) > 0) {
                resize(getCapacity() >> 1);
            }
        }
        return datum;
    }

    private void resize(int newCapacity) {
        // 新的空间不足以容纳已有数据，抛出异常
        int size = getSize();
        if (size > newCapacity) {
            throw new IllegalArgumentException(String.format("Required capacity >= size! Current size:[%d], new capacity:[%d] ", size, newCapacity));
        }
        E[] objects = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            objects[i] = data[(i + front) % getCapacity()];
        }
        data = objects;
        front = 0;
        tail = size - 1;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            return null;
        }
        return data[front];
    }
}
