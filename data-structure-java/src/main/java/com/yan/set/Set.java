package com.yan.set;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/30 0030 16:09
 */
public interface Set<E> {
    void add(E e);

    void remove(E e);

    int size();

    default boolean isEmpty() {
        return size() < 1;
    }

    boolean contains(E e);
}
