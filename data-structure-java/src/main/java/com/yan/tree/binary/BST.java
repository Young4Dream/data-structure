package com.yan.tree.binary;

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

    public static void main(String[] args) {
        BST<Integer> integerBST = new BST<>();
        integerBST.add(8);
        integerBST.add(6);
        integerBST.add(11);
        integerBST.add(3);
        integerBST.add(7);
        integerBST.add(9);
        integerBST.add(12);
        ///////////////////
        //       8       //
        //     /   \     //
        //   6      11   //
        //  / \    /  \  //
        //3    7  9    12//
        ///////////////////
        integerBST.contains(9);
        //8,6,3,7,11,9,12
        integerBST.preOrderNR();
        //3,6,7,8,9,11,12
        integerBST.midOrder();
        //3,7,6,9,12,11,8
        integerBST.postOrder();
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
        return null;
    }

    /**
     * 删除最大元素
     *
     * @return 最大元素
     */
    public E removeMax() {
        return null;
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
            return contains(node.left, e);
        }
        return contains(node.right, e);
    }

    class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
        }
    }
}
