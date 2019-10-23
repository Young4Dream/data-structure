package com.yan.tree.binary;

/**
 * BST: Binary Search Tree, 二分搜索树。
 *
 * @author Administrator
 * @since 1.0.0
 * 2019/10/21 0021 13:38
 */
public class BST<E extends Comparable<E>> {
    private Node node;
    private int size;

    public int size() {
        return size;
    }

    class Node {
        private E e;
        private Node left, right;
    }
}
