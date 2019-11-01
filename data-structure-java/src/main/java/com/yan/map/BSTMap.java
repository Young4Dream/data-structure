package com.yan.map;

@SuppressWarnings("all")
public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    @Override
    public V remove(K k) {
        return null;
    }

    @Override
    public boolean containsKey(K k) {
        return false;
    }

    @Override
    public V get(K k) {
        return null;
    }

    @Override
    public void set(K k, V v) {

    }

    @Override
    public int size() {
        return size;
    }

    public Node add(Node node, K k, V v) {
        if (node == null) {
            size++;
            return new Node(k, v);
        }
        if (k.compareTo(node.key) < 0) {
            node.left = add(node.left, k, v);
        } else if (k.compareTo(node.key) > 0) {
            node.right = add(node.right, k, v);
        } else {
            node.value = v;
        }
        return node;
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            if (null == next) {
                return;
            }
            if (key.compareTo(next.key) > 0) {
                left = next;
            } else if (key.compareTo(next.key) < 0) {
                right = next;
            }
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null);
        }
    }
}
