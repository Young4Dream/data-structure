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
 * 2019/11/12 16:51
 */
@RunWith(JUnit4.class)
public class TrieTest {
    private Trie trie;
    private com.yan.tree.recursion.Trie rTrie;

    @Before
    public void before() {
        trie = new Trie();
        rTrie = new com.yan.tree.recursion.Trie();
    }

    @Test
    public void test() {
        trie.add("Hello World!");
        rTrie.add("Hello World!");
        rTrie.add("abc");
        rTrie.add("abd");
        System.out.println(trie.startsWith("A"));
        System.out.println(trie.startsWith("H"));
        System.out.println(rTrie.startsWith("a"));
//        rTrie.remove("abd");
        rTrie.remove("a");
        rTrie.remove("c");
    }

    @Test
    public void test_remove() {
        rTrie.add("ab");
        rTrie.add("abd");
        rTrie.remove("abd");
        Assert.assertFalse(rTrie.contains("abd"));
        rTrie.remove("c");
        Assert.assertEquals(1, rTrie.size());
        rTrie.remove("a");
        Assert.assertEquals(1, rTrie.size());
        rTrie.add("hello");


    }

    @After
    public void after() {

    }
}