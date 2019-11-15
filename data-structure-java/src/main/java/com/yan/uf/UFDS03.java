package com.yan.uf;

import java.util.Arrays;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/15 14:48
 */
public class UFDS03 extends AbstractUFDS {
    /**
     * 同一指针下元素的多少，合并时会根据这个数值来判断应该挪动那些元素，原则上谁小挪谁
     */
    private int[] _size;

    public UFDS03(int size) {
        super(size);
        _size = new int[size];
        Arrays.fill(_size, 1);
    }

    // 索引ie对应的根节点的值，它的特点是索引值与元素值相等
    int findRoot(int ie) {
        checkIndex(ie);
        while (ie != parent[ie]) {
            ie = parent[ie];
        }
        return ie;
    }

    @Override
    public void union(int ip, int iq) {
        int pRoot = findRoot(ip);
        int qRoot = findRoot(iq);
        if (pRoot == qRoot) {
            return;
        }
        int sp = _size[pRoot];
        int sq = _size[qRoot];
        int new_size = sp + sq;
        if (sp > sq) {
            parent[qRoot] = pRoot;
            _size[qRoot] = new_size;
        } else {
            parent[pRoot] = qRoot;
            _size[pRoot] = new_size;
        }

    }
}
