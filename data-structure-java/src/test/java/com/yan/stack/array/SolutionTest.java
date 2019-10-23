package com.yan.stack.array;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/8 0008 11:31
 */
@RunWith(JUnit4.class)
public class SolutionTest {
    private Solution solution;

    @Before
    public void before() {
        solution = new Solution();
    }

    @Test
    public void test_valid() {
        boolean valid = solution.isValid("(a)");
        Assert.assertTrue(valid);
        valid = solution.isValid("(a)）");
        Assert.assertFalse(valid);
        valid = solution.isValid("（a)）");
        Assert.assertFalse(valid);
        valid = solution.isValid("（()）");
        Assert.assertTrue(valid);
    }

}
