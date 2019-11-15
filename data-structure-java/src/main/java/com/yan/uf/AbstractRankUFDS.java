package com.yan.uf;

import java.util.Arrays;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/15 15:41
 */
abstract class AbstractRankUFDS extends AbstractUFDS {
    /**
     * 同一指针下的排名数组，合并时会根据这个数值来判断应该挪动那些元素，原则上谁小挪谁
     */
    int[] rank;

    AbstractRankUFDS(int size) {
        super(size);
        rank = new int[size];
        Arrays.fill(rank, 1);
    }

}
