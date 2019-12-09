package com.yan.tree;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

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
    public void test_contains() {
        rTrie.add("abc");
        assertFalse(rTrie.contains("ab"));
        assertTrue(rTrie.contains("abc"));
    }

    @Test
    public void test_remove() {
        rTrie.add("ab");
        rTrie.add("a");
        rTrie.remove("a");
        assertEquals(1, rTrie.size());
        rTrie.add("a");
        rTrie.remove("ab");
        assertFalse(rTrie.contains("ab"));
        rTrie.remove("c");
        rTrie.remove("a");
        assertEquals(0, rTrie.size());
        rTrie.add("hello");
        rTrie.remove("hel");
        assertEquals(1, rTrie.size());
        assertTrue(rTrie.contains("hello"));
    }

    @After
    public void after() {

    }
}