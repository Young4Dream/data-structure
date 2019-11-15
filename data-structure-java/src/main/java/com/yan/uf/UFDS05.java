package com.yan.uf;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/15 14:48
 */
public class UFDS05 extends AbstractRankUFDS {
    public UFDS05(int size) {
        super(size);
    }

    @Override
    int findRoot(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while (p != parent[p]) {
            p = parent[p] = parent[parent[p]];
        }
        return p;
    }

    @Override
    public void union(int ip, int iq) {
        int pRoot = findRoot(ip);
        int qRoot = findRoot(iq);
        if (pRoot == qRoot) {
            return;
        }
        int pRank = rank[pRoot];
        int qRank = rank[qRoot];
        if (pRank > qRank) {
            parent[qRoot] = pRoot;
        } else if (pRank < qRank) {
            parent[pRoot] = qRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot] += 1;
        }
    }
}
