package com.yan.collection;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/22 0022 10:12
 */
public interface Collection<E> {
    int size();

    default boolean isEmpty() {
        return size() == 0;
    }

    E get(int index);

    default E getFirst() {
        return get(0);
    }

    default E getLast() {
        return get(size() - 1);
    }

    void add(E e);

    boolean remove(int index);

    void removeElement(E e);

    default boolean removeFirst() {
        return remove(0);
    }

    default boolean removeLast() {
        return remove(size() - 1);
    }

    void update(int index, E e);

    boolean contains(E e);

}
