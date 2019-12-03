package com.yan.uf;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/15 15:41
 */
public abstract class AbstractUFDS implements UFDS {
    int[] parent;

    AbstractUFDS(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    abstract int findRoot(int i);

    void checkIndex(int i) {
        if (i < 0 || i >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
    }

    @Override
    public int size() {
        return parent.length;
    }
}
