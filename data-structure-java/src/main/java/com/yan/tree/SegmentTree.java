package com.yan.tree;

import java.util.StringJoiner;
import java.util.function.BinaryOperator;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/8 0008 13:56
 */
@SuppressWarnings("all")
public class SegmentTree<E> {
    private E[] tree;
    private E[] data;
    private BinaryOperator<E> merger;

    public SegmentTree(BinaryOperator<E> merger, E... arr) {
        this.merger = merger;
        data = arr.clone();
        // enough capacity
        tree = (E[]) new Object[arr.length << 1 << 1];
        buildSegmentTree(0, 0, size() - 1);
    }

    private void buildSegmentTree(int index, int l, int r) {
        if (l == r) {
            tree[index] = data[l];
            return;
        }
        int left = left(index);
        int right = right(index);
        int mid = l + (r - l) / 2;
        buildSegmentTree(left, l, mid);
        buildSegmentTree(right, mid + 1, r);
        tree[index] = merger.apply(tree[left], tree[right]);
    }

    /**
     * 非完全二叉树，size==capacity==length
     *
     * @return size
     */
    public int size() {
        return data.length;
    }

    public E query(int left, int right) {
        if (left < 0 || left >= data.length ||
                right < 0 || right >= data.length || left > right)
            throw new IllegalArgumentException("Index is illegal.");
        return query(0, 0, size() - 1, left, right);
    }

    /**
     * 根据左右范围索引值[lq,rq]递归查询
     * [l,r]肯定是包含[lq,rq]的
     *
     * @param index 当前片段树索引
     * @param l     当前片段树索引下支持的最小索引值
     * @param r     当前片段树索引下支持的最大索引值
     * @param lq    结果需要的最小索引值
     * @param rq    结果需要的最大索引值
     * @return 返回索引范围在(lq, rq)的结果融合值
     */
    private E query(int index, int l, int r, int lq, int rq) {
        if (l == lq && r == rq) {
            return tree[index];
        }
        int lc = left(index);
        int rc = right(index);
        int mid = mid(l, r);
        if (lq > mid) {
            return query(rc, mid + 1, r, lq, rq);
        }
        if (rq <= mid) {
            return query(lc, l, mid, lq, rq);
        }
        // 左子树融合结果
        E lr = query(lc, l, mid, lq, mid);
        // 右子树融合结果
        E rr = query(rc, mid + 1, r, mid + 1, rq);
        return merger.apply(lr, rr);
    }

    public E get(int index) {
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        return data[index];
    }

    private int left(int index) {
        return (index << 1) + 1;
    }

    private int right(int index) {
        return left(index) + 1;
    }

    private int mid(int l, int r) {
        return l + (r - l) / 2;
    }

    public void set(int index, E e) {
        set(0, 0, size() - 1, index, e);
    }

    public void setByRebuild(int index, E e) {
        data[index] = e;
        buildSegmentTree(0, 0, size() - 1);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = mid(l, r);
        int left = left(treeIndex);
        int right = right(treeIndex);
        if (index > mid) {
            set(right, mid + 1, r, index, e);
        } else {
            set(left, l, mid, index, e);
        }
        tree[treeIndex] = merger.apply(tree[left], tree[right]);
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", SegmentTree.class.getSimpleName() + "[", "]");
        for (E e : tree) stringJoiner.add(String.valueOf(e));
        return stringJoiner.toString();
    }
}
