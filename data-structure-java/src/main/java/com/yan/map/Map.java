package com.yan.map;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/30 0030 17:41
 */
public interface Map<K, V> {
    void add(K k, V v);

    V remove(K k);

    boolean containsKey(K k);

    V get(V v);

    void set(K k, V v);

    int size();

    default boolean isEmpty() {
        return size() < 1;
    }
}
