package com.yan.tree.leetcode;

import java.util.TreeMap;

/**
 * https://leetcode-cn.com/problems/add-and-search-word-data-structure-design/
 * <p>
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 *
 * @author Administrator
 * @since 1.0.0
 * 2019/11/13 10:48
 */
public class WordDictionary {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur.next.putIfAbsent(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return match(word, root, 0);
    }

    private boolean match(CharSequence searchWord, Node node, int index) {
        if (index == searchWord.length()) {
            return node.isWord;
        }
        char c = searchWord.charAt(index);
        if (c != '.') {
            if (null == node.next.get(c)) {
                return false;
            }
            return match(searchWord, node.next.get(c), index + 1);
        } else {
            for (char c1 : node.next.keySet()) {
                if (match(searchWord, node.next.get(c1), index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    protected static class Node {
        public TreeMap<Character, Node> next;
        boolean isWord;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }
    }
}
