package com.yan.tree.leetcode;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/13 15:33
 */
@RunWith(JUnit4.class)
public class MapSumTest {
    private MapSum mapSum;

    @Before
    public void before() {
        mapSum = new MapSum();
    }

    @Test
    public void test() {
        mapSum.insert("aa", 3);
        Assert.assertEquals(3, mapSum.sum("a"));
        mapSum.insert("aa", 2);
        Assert.assertEquals(2, mapSum.sum("a"));
        mapSum.insert("apple", 3);
        Assert.assertEquals(3, mapSum.sum("ap"));
        mapSum.insert("app", 2);
        Assert.assertEquals(5, mapSum.sum("ap"));
    }

    @After
    public void after() {

    }
}