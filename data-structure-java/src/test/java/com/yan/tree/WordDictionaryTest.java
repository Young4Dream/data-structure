package com.yan.tree;

import com.yan.tree.leetcode.WordDictionary;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/13 11:55
 */
@RunWith(JUnit4.class)
public class WordDictionaryTest {
    private WordDictionary wordDictionary;

    @Before
    public void before() {
        wordDictionary = new WordDictionary();
    }

    @Test
    public void test() {
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assert.assertFalse(wordDictionary.search("pad"));
        Assert.assertTrue(wordDictionary.search("bad"));
        Assert.assertTrue(wordDictionary.search(".ad"));
        Assert.assertTrue(wordDictionary.search("b.."));
    }

    @Test
    public void test_leetcode() {
        add("at", "and", "an", "add");
        Assert.assertFalse(wordDictionary.search("a"));
        Assert.assertFalse(wordDictionary.search(".at"));
        add("bat");
        Assert.assertTrue(wordDictionary.search(".at"));
        Assert.assertTrue(wordDictionary.search("an."));
        Assert.assertFalse(wordDictionary.search("a.b."));
        Assert.assertFalse(wordDictionary.search("b."));
        Assert.assertTrue(wordDictionary.search("a.d"));
        Assert.assertFalse(wordDictionary.search("."));
    }

    private void add(String... charSequences) {
        for (String charSequence : charSequences) {
            wordDictionary.addWord(charSequence);
        }
    }

    @After
    public void after() {

    }
}