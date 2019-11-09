package com.yan.tree;

import java.util.Stack;

/**
 * BST: Binary Search Tree, 二分搜索树。
 *
 * @author Administrator
 * @since 1.0.0
 * 2019/10/21 0021 13:38
 */
@SuppressWarnings("all")
public class BST<E extends Comparable<E>> {
    private Node root;
    private int size;

    public int size() {
        return size;
    }

    public void remove(E e) {
        if (!contains(e)) {
            return;
        }
        root = remove(root, e);
    }

    public Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) > 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
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
        node = null;
        return successor;
    }

    private void midOrder(Node node) {
        if (null == node) {
            return;
        }
        midOrder(node.left);
        System.out.println(node.e);
        midOrder(node.right);
    }

    /**
     * 删除最小元素
     *
     * @return 最小元素
     */
    public E removeMin() {
        Node minimum = minimum(root);
        if (minimum == null) {
            return null;
        }
        root = removeMin(root);
        return minimum.e;
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

    /**
     * 删除最大元素
     *
     * @return 最大元素
     */
    public E removeMax() {
        Node maximum = maximum(root);
        if (maximum == null) {
            return null;
        }
        root = removeMax(root);
        return maximum.e;
    }

    private Node removeMax(Node node) {
        if (null == node) {
            return null;
        }
        if (node.right == null) {
            Node rN = node.left;
            node.left = null;
            size--;
            return rN;
        }
        node.right = removeMin(node.right);
        return node;
    }

    private Node maximum(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right == null) {
            return node;
        }
        return maximum(node.right);
    }

    public void preOrder() {
        System.out.println("============前序遍历开始============");
        preOrder(root);
        System.out.println("============前序遍历结束============");
    }

    /**
     * 前序遍历的非递归实现
     */
    public void preOrderNR() {
        System.out.println("============前序遍历开始============");
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.e);
            if (null != node.right)
                stack.push(node.right);
            if (null != node.left)
                stack.push(node.left);
        }
        System.out.println("============前序遍历结束============");
    }

    public void midOrder() {
        System.out.println("============中序遍历开始============");
        midOrder(root);
        System.out.println("============中序遍历结束============");
    }

    public void postOrder() {
        System.out.println("============后序遍历开始============");
        postOrder(root);
        System.out.println("============后序遍历结束============");
    }

    private void preOrder(Node node) {
        if (null == node) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    private void postOrder(Node node) {
        if (null == node) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    public void add(E e) {
        root = add(root, e);
    }

    public Node add(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        }
        if (node.e.compareTo(e) < 0) {
            return contains(node.right, e);
        }
        return contains(node.left, e);
    }

    class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }
}
