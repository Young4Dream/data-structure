package com.yan.uf;

/**
 * 此时的rank代表的是树的高度
 *
 * @author Administrator
 * @since 1.0.0
 * 2019/11/15 14:48
 */
public class UFDS04 extends AbstractRankUFDS {
    public UFDS04(int size) {
        super(size);
    }

    // 索引e对应的根节点的值，它的特点是索引值与元素值相等
    int findRoot(int e) {
        checkIndex(e);
        while (e != parent[e]) {
            e = parent[e];
        }
        return e;
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
        // 此时的rank代表的是树的高度，当低树往高树上合并时，并不影响高树的最高高度，只有相同高度的索引合并时，高度会+1
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
