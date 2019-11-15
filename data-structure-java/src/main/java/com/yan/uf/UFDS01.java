package com.yan.uf;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/15 14:48
 */
public class UFDS01 extends AbstractUFDS {

    public UFDS01(int size) {
        super(size);
    }

    @Override
    int findRoot(int i) {
        return parent[i];
    }

    @Override
    public void union(int p, int q) {
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if (pRoot == qRoot) {
            return;
        }
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == pRoot) {
                parent[i] = qRoot;
            }
        }
    }
}
