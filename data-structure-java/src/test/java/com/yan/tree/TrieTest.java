package com.yan.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/12 16:51
 */
@RunWith(JUnit4.class)
public class TrieTest {
    private Trie trie;

    @Before
    public void before() {
        trie = new Trie();
    }

    @Test
    public void test() {
        trie.add("Hello World!");
        System.out.println(trie.startsWith("A"));
        System.out.println(trie.startsWith("H"));
    }

    @After
    public void after() {

    }
}