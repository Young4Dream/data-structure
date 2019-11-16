package com.yan.tree;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/16 15:34
 */
public class AVL<K extends Comparable<K>, V> {
    private Node root;
    private int size;


    public void add(K k, V v) {
        root = add(root, k, v);
    }

    private int getHeight(Node node) {
        if (null == node) {
            return 0;
        }
        return node.height;
    }

    public V remove(K k) {
        Node remove = remove(root, k);
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


    public V get(K k) {
        Node node = getNode(root, k);
        return null == node ? null : node.value;
    }


    public void set(K k, V v) {
        Node node = getNode(root, k);
        if (null == node) {
            throw new IllegalArgumentException(k + " doesn't exist!");
        }
        node.value = v;
    }


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
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return node;
    }

    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    @SuppressWarnings("all")
    private class Node {
        public K key;
        public V value;
        public int height;
        public Node left, right;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.height = 1;
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
