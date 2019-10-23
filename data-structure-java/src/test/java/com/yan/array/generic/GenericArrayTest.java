package com.yan.array.generic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/9/30 0030 15:57
 */
@RunWith(JUnit4.class)
public class GenericArrayTest {
    @Before
    public void before() {

    }

    @Test
    public void test() {
        Array<Integer> arr = new Array<>(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
    }

    @After
    public void after() {

    }
}