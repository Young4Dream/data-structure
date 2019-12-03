package com.yan.tree;

import java.util.*;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/25 16:58
 */
@SuppressWarnings("all")
public class RBTree<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int size;

    private static int getHeight(Node node) {
        if (null == node)
            return 0;
        return node.height;
    }

    public static boolean isRed(Node node) {
        return node == null ? Node.BLACK : node.color;
    }

    public V get(K k) {
        Node<K, V> node = getNode(root, k);
        if (null == node) {
            return null;
        }
        return node.value;
    }

    public void set(K k, V v) {
        Node<K, V> node = getNode(root, k);
        if (null == node) {
            add(k, v);
            return;
        }
        node.value = v;
    }

    public boolean containsKey(K k) {
        return null != getNode(root, k);
    }
    // 返回以node为根节点的二分搜索树中，key所在的节点
    private Node<K, V> getNode(Node<K, V> node, K k) {
        if (node == null) {
            return null;
        }
        if (k.compareTo(node.key) == 0) {
            return node;
        }
        if (k.compareTo(node.key) > 0) {
            return getNode(node.right, k);
        }
        return getNode(node.left, k);
    }

    public void add(K k, V v) {
        root = add(root, k, v);
        root.color = Node.BLACK;
    }

    public int size() {
        return size;
    }

    private Node<K, V> add(Node<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new Node<>(key, value);
        }
        if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else {
            node.value = value;
        }
        return node.refresh();
    }

    public Set<Node<K, V>> nodeSet() {
        Set<Node<K, V>> set = new LinkedHashSet<>();
        fillSet(root, set);
        return set;
    }

    private void fillSet(Node<K, V> node, Set<Node<K, V>> set) {
        if (node == null) {
            return;
        }
        fillSet(node.left, set);
        set.add(node);
        fillSet(node.right, set);
    }


    @SuppressWarnings("all")
    static class Node<K extends Comparable<K>, V> {
        private static final Boolean RED = true;
        private static final Boolean BLACK = false;
        public K key;
        public V value;
        public int height;
        public Node<K, V> left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
            this.color = RED;
        }

        /**
         * 保持（黑）平衡并翻转颜色
         *
         * @return
         */
        public Node<K, V> refresh() {
            Node<K, V> self = this;
            // 左子树为红，表示不为空，无需判空
            if (isRed(self.left) && isRed(self.left.left)) {
                self = self.rightRotate();
            }
            if (!isRed(self.left) && isRed(self.right)) {
                self = self.leftRotate();
            }
            if (isRed(self.left) && isRed(self.right)) {
                self.flipColor();
            }
            self.height = 1 + Math.max(getHeight(self.left), getHeight(self.right));
            return self;
        }

        // 左右子树颜色均为红色才会出现翻转，因此不存在为空状况，此方法不影响树的高度
        private void flipColor() {
            this.color = RED;
            this.left.color = this.right.color = BLACK;
        }

        public Node<K, V> rightRotate() {
            Node<K, V> x = left;
            left = x.right;
            x.right = this;
            // 其实可以直接赋值为BLACK
            x.color = color;
            color = RED;
            return x;
        }

        public Node<K, V> leftRotate() {
            Node<K, V> x = right;
            right = x.left;
            x.left = this;
            x.color = color;
            color = RED;
            return x;
        }
    }
}
