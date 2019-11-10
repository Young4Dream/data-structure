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
    private BinaryOperator<E> operator;

    public SegmentTree(BinaryOperator<E> operator, E... arr) {
        this.operator = operator;
        data = arr.clone();
        // enough capacity
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

    public E query(int left, int right) {
        return query(0, 0, size() - 1, left, right);
    }

    /**
     * 根据左右范围索引值(lq,rq)递归查询
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
        E rr = query(rc, mid + 1, rc, mid + 1, rq);
        return operator.apply(lr, rr);
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

    private void buildSegmentTree(int index, int l, int r) {
        if (l == r) {
            tree[index] = data[l];
            return;
        }
        int left = left(index);
        int right = right(index);
        int mid = mid(l, r);
        buildSegmentTree(left, l, mid);
        buildSegmentTree(right, mid + 1, r);
        tree[index] = operator.apply(tree[left], tree[right]);
    }

    private int mid(int l, int r) {
        return l + (r - l) / 2;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", SegmentTree.class.getSimpleName() + "[", "]");
        for (E e : data) stringJoiner.add(String.valueOf(e));
        return stringJoiner.toString();
    }
}
