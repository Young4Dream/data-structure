package com.yan.tree;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/11 0011 09:41
 */
@RunWith(JUnit4.class)
public class SegmentTreeTest {
    private SegmentTree<Integer> segmentTree;
    private com.yan.tree.teacher.SegmentTree<Integer> tSegmentTree;

    @Before
    public void before() {
//        6, 5, 4, 3,
        tSegmentTree = new com.yan.tree.teacher.SegmentTree<>(new Integer[]{6, 5, 4, 3, 2, 1, 0}, Integer::sum);
        segmentTree = new SegmentTree<>(Integer::sum, 6, 5, 4, 3, 2, 1, 0);
    }

    @Test
    public void test() {
        System.out.println(tSegmentTree);
        System.out.println(segmentTree);

        System.out.println(tSegmentTree.query(1, 3));
        System.out.println(segmentTree.query(1, 3));

        Assert.assertEquals(tSegmentTree.query(0, 1), segmentTree.query(0, 1), 0);
        Assert.assertEquals(tSegmentTree.query(1, 3), segmentTree.query(1, 3), 0);
        Assert.assertEquals(tSegmentTree.query(2, 6), segmentTree.query(2, 6), 0);
        Assert.assertEquals(tSegmentTree.query(0, 6), segmentTree.query(0, 6), 0);
        Assert.assertEquals(tSegmentTree.query(3, 6), segmentTree.query(3, 6), 0);
    }

    @Test
    public void test_set() {
        segmentTree.set(2, 12);
//        Assert.assertEquals(12, (int) segmentTree.get(2));
        Assert.assertEquals(20, (int) segmentTree.query(1, 3));
        segmentTree.setByRebuild(2, 13);
//        Assert.assertEquals(12, (int) segmentTree.get(2));
        Assert.assertEquals(21, (int) segmentTree.query(1, 3));
    }

    @After
    public void after() {

    }
}