package com.yan.tree;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/8 0008 13:56
 */
@SuppressWarnings("all")
public class SegmentTree<E extends Cloneable> {
    private E[] tree;
    private E[] data;

    public SegmentTree(E[] arr) {
        data = arr.clone();
        tree = (E[]) new Object[arr.length << 1 << 1];
        buildSegmentTree(0, 0, size() - 1);
    }

    /**
     * 非完全二叉树，size==capacity==length
     *
     * @return size
     */
    public int size() {
        return data.length;
    }

    public E get(int index) {
        return data[index];
    }

    private int left(int index) {
        return index << 1 + 1;
    }

    private int right(int index) {
        return left(index) + 1;
    }

    private void buildSegmentTree(int treeIndex, int l, int r) {

    }
}
