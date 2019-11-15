package com.yan.uf;

/**
 * UFDS: Union Find Disjoint Sets
 * <a href="https://baike.baidu.com/item/%E5%B9%B6%E6%9F%A5%E9%9B%86/9388442?fr=aladdin">并查集</a><br/>
 * <a href="https://visualgo.net/zh/ufds">可视化</a>
 *
 * @author Administrator
 * @since 1.0.0
 * 2019/11/14 17:20
 */
public interface UFDS {
    boolean isConnected(int p, int q);

    void union(int p, int q);

    int size();
}
