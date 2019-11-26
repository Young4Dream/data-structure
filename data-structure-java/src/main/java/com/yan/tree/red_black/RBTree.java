package com.yan.tree.red_black;

import java.util.StringJoiner;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/25 16:58
 */
public class RBTree<K extends Comparable<K>, V> {

    private Node<K, V> root;
    private int size;

    private static int getHeight(Node node) {
        if (null == node)
            return 0;
        return node.height;
    }

    private static boolean isRed(Node node) {
        return node == null ? Node.BLACK : node.color;
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
        }

        private boolean isBalanced(Node node) {
            if (node == null)
                return true;
            int balanceFactor = node.getBalanceFactor();
            if (Math.abs(balanceFactor) > 1)
                return false;
            return isBalanced(node.left) && isBalanced(node.right);
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
            if (isRed(self.right) && !isRed(self.left)) {
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

        private int getBalanceFactor() {
            int leftHight = left == null ? 0 : left.height;
            int rightHight = right == null ? 0 : right.height;
            return leftHight - rightHight;
        }

        public Node<K, V> rightRotate() {
            Node x = this.left;
            Node t = x.right;
            x.color = color;
            color = RED;
            return x;
        }

        public Node<K, V> leftRotate() {
            Node<K, V> x = right;
            right = x.left;
            x.color = color;
            color = RED;
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
