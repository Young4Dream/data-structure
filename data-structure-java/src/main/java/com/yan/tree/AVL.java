package com.yan.tree;

import java.util.*;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/16 15:34
 */
public class AVL<K extends Comparable<K>, V> {
    private Node<K, V> root;
    private int size;

    private static int getHeight(Node node) {
        if (null == node)
            return 0;
        return node.height;
    }

    public V remove(K k) {
        Node<K, V> node = getNode(root, k);
        root = remove(root, k);
        return node == null ? null : node.value;
    }

    public Node<K, V> remove(Node<K, V> node, K k) {
        if (node == null) {
            return null;
        }
        if (k.compareTo(node.key) < 0) {
            node.left = remove(node.left, k);
            return node.balance();
        } else if (k.compareTo(node.key) > 0) {
            node.right = remove(node.right, k);
            return node.balance();
        }
        size--;
        if (node.left == null) {
            Node<K, V> right = node.right;
            node.right = null;
            return balance(right);
        }
        if (node.right == null) {
            Node<K, V> left = node.left;
            node.left = null;
            return balance(left);
        }
        Node<K, V> successor = minimum(node.right);
        successor.right = remove(node.right, successor.key);
        size++;
        successor.left = node.left;
        node.left = node.right = null;
        return balance(successor);
    }

    private Node<K, V> balance(Node<K, V> node) {
        return node == null ? null : node.balance();
    }

    private Node<K, V> removeMin(Node<K, V> node) {
        if (null == node) {
            return null;
        }
        if (node.left == null) {
            Node<K, V> rN = node.right;
            node.right = null;
            size--;
            return balance(rN);
        }
        node.left = removeMin(node.left);
        return node.balance();
    }

    private Node<K, V> minimum(Node<K, V> node) {
        if (node == null) {
            return null;
        }
        if (node.left == null) {
            return node.balance();
        }
        return balance(minimum(node.left));
    }

    @SuppressWarnings("all")
    public boolean containsKey(K k) {
        return getNode(root, k) != null;
    }

    private Node<K, V> getNode(Node<K, V> node, K k) {
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
        Node<K, V> node = getNode(root, k);
        return null == node ? null : node.value;
    }

    public void set(K k, V v) {
        Node<K, V> node = getNode(root, k);
        if (null == node) {
            throw new IllegalArgumentException(k + " doesn't exist!");
        }
        node.value = v;
    }

    public void add(K k, V v) {
        root = add(root, k, v);
    }

    @SuppressWarnings("all")
    public boolean isBalanced() {
        return root == null || root.isBalanced();
    }


    @SuppressWarnings("all")
    public Set<K> keySet() {
        TreeSet<K> ks = new TreeSet<>();
        keySet(root, ks);
        return ks;
    }

    private void keySet(Node<K, V> node, TreeSet<K> ks) {
        if (null == node) {
            return;
        }
        ks.add(node.key);
        keySet(node.left, ks);
        keySet(node.right, ks);
    }

    public Node<K, V> add(Node<K, V> node, K k, V v) {
        if (node == null) {
            size++;
            return new Node<>(k, v);
        }
        Comparator<K> kComparator = Comparator.naturalOrder();
        if (Objects.compare(k, node.key, kComparator) < 0) {
            node.left = add(node.left, k, v);
        } else if (Objects.compare(k, node.key, kComparator) > 0) {
            node.right = add(node.right, k, v);
        } else {
            node.value = v;
        }
        // reset height because which child added finally is not sure
//        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        return node.balance();
    }

    public int size() {
        return size;
    }

    @SuppressWarnings("all")
    static class Node<K, V> {
        public K key;
        public V value;
        public int height;
        public Node<K, V> left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }

        private boolean isBalanced(Node node) {
            if (node == null)
                return true;
            int balanceFactor = node.getBalanceFactor();
            if (Math.abs(balanceFactor) > 1)
                return false;
            return isBalanced(node.left) && isBalanced(node.right);
        }

        private void refreshHight() {
            height = 1 + Math.max(getHeight(left), getHeight(right));
        }

        public Node<K, V> balance() {
            refreshHight();
            int balanceFactor = getBalanceFactor();
            if (balanceFactor > 1 && left.getBalanceFactor() >= 0) {
                return rightRotate();
            }
            if (balanceFactor < -1 && right.getBalanceFactor() <= 0) {
                return leftRotate();
            }
            if (balanceFactor > 1 && left.getBalanceFactor() < 0) {
                left = left.leftRotate();
                return rightRotate();
            }
            if (balanceFactor < -1 && right.getBalanceFactor() > 0) {
                right = right.rightRotate();
                return leftRotate();
            }
            return this;
        }

        private int getBalanceFactor() {
            int leftHight = left == null ? 0 : left.height;
            int rightHight = right == null ? 0 : right.height;
            return leftHight - rightHight;
        }

        public Node<K, V> rightRotate() {
            Node x = this.left;
            Node t = x.right;

            // 向右旋转过程
            x.right = this;
            this.left = t;

            // 更新height
            this.height = Math.max(getHeight(this.left), getHeight(this.right)) + 1;
            x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

            return x;
        }

        public Node<K, V> leftRotate() {
            Node x = this.right;
            Node t = x.left;
            x.left = this;
            this.right = t;
            this.height = Math.max(getHeight(this.left), getHeight(this.right)) + 1;
            x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
            return x;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("key=" + key)
                    .add("height=" + height)
                    .add("left=" + (left == null ? null : "[key=" + left.key + ",height=" + left.height + "]"))
                    .add("right=" + (right == null ? null : "[key=" + right.key + ",height=" + right.height + "]"))
                    .toString();
        }

        public boolean isBalanced() {
            return isBalanced(this);
        }
    }

}
