package com.yan.queue;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/8 0008 13:45
 */
public interface Queue<E> {
    int getSize();

    default boolean isEmpty() {
        return getSize() == 0;
    }

    void enqueue(E e);

    E dequeue();

    E getFront();
}
