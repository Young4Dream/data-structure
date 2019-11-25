package com.yan.map;

import java.util.Comparator;
import java.util.Objects;


public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private Node root;
    private int size;

    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    @Override
    public V remove(K k) {
        Node remove = getNode(root, k);
        root = remove(root, k);
        return remove == null ? null : remove.value;
    }

    public Node remove(Node node, K k) {
        if (node == null) {
            return null;
        }
        if (k.compareTo(node.key) < 0) {
            node.left = remove(node.left, k);
            return node;
        } else if (k.compareTo(node.key) > 0) {
            node.right = remove(node.right, k);
            return node;
        }
        size--;
        if (node.left == null) {
            Node right = node.right;
            node.right = null;
            return right;
        }
        if (node.right == null) {
            Node left = node.left;
            node.left = null;
            return left;
        }
        Node successor = minimum(node.right);
        successor.right = removeMin(node.right);
        size++;
        successor.left = node.left;
        node.left = node.right = null;
        return successor;
    }

    private Node removeMin(Node node) {
        if (null == node) {
            return null;
        }
        if (node.left == null) {
            Node rN = node.right;
            node.right = null;
            size--;
            return rN;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private Node minimum(Node node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    @Override
    public boolean containsKey(K k) {
        return getNode(root, k) != null;
    }

    private Node getNode(Node node, K k) {
        if (null == node) {
            return null;
        }
        if (k.compareTo(node.key) == 0) {
            return node;
        }
        if (k.compareTo(node.key) < 0) {
            return getNode(node.left, k);
        }
        return getNode(node.right, k);
    }

    @Override
    public V get(K k) {
        Node node = getNode(root, k);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (null == node) {
            throw new IllegalArgumentException(k + " doesn't exist!");
        }
        node.value = v;
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
        Comparator<K> kComparator = Comparator.naturalOrder();
        if (Objects.compare(k, node.key, kComparator) < 0) {
            node.left = add(node.left, k, v);
        } else if (Objects.compare(k, node.key, kComparator) > 0) {
            node.right = add(node.right, k, v);
        } else {
            node.value = v;
        }
        return node;
    }

    @SuppressWarnings("all")
    private class Node {
        K key;
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
