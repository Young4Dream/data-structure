package com.yan.map;

import com.yan.tree.AVLTree;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/25 12:15
 */
public class AVLMap<K extends Comparable<K>, V> implements Map<K, V> {
    private AVLTree<K, V> avlTree;

    public AVLMap() {
        avlTree = new AVLTree<>();
    }

    @Override
    public void add(K k, V v) {
        avlTree.add(k, v);
    }

    @Override
    public V remove(K k) {
        return avlTree.remove(k);
    }

    @Override
    public boolean containsKey(K k) {
        return avlTree.containsKey(k);
    }

    @Override
    public V get(K k) {
        return avlTree.get(k);
    }

    @Override
    public void set(K k, V v) {
        avlTree.set(k, v);
    }

    @Override
    public int size() {
        return avlTree.size();
    }
}
