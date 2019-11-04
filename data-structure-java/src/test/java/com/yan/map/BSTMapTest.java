package com.yan.map;

import com.yan.util.FileOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/1 0001 16:35
 */
@RunWith(JUnit4.class)
public class BSTMapTest {
    private Map<String, Integer> map;

    @Before
    public void before() {
        map = new BSTMap<>();
    }

    @Test
    public void test() {
        @SuppressWarnings("all")
        String path = this.getClass().getClassLoader().getResource("pride-and-prejudice.txt").getPath();
        List<String> strings = FileOperation.readFile(path);
        Assert.assertEquals(125901, strings.size());
        strings.forEach(s -> {
            Integer integer = map.get(s);
            int value = integer == null ? 1 : integer + 1;
            map.add(s, value);
        });
        Assert.assertEquals(6530, map.size());
    }

    @After
    public void after() {
    }
}