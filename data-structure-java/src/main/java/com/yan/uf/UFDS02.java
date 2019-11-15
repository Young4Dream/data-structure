package com.yan.uf;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/15 14:48
 */
public class UFDS02 extends AbstractUFDS {

    public UFDS02(int size) {
        super(size);
    }

    int findRoot(int e) {
        checkIndex(e);
        while (e != parent[e]) {
            e = parent[e];
        }
        return e;
    }

    @Override
    public void union(int p, int q) {
        int _p = findRoot(p);
        int _q = findRoot(q);
        if (_p == _q) {
            return;
        }
        parent[_p] = _q;
    }
}
