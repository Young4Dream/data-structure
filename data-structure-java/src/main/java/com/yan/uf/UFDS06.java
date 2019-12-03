package com.yan.uf;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/15 14:48
 */
public class UFDS06 extends AbstractRankUFDS {
    public UFDS06(int size) {
        super(size);
    }

    /**
     * Path Compression 路径压缩
     *
     * @param p 索引
     * @return 返回根节点
     */
    @Override
    int findRoot(int p) {
        if (p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        if (p != parent[p]) {
            parent[p] = findRoot(parent[p]);
        }
        return parent[p];
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
