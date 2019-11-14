package com.yan.tree;

import java.util.TreeMap;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/12 13:38
 */
@SuppressWarnings("all")
public class Trie {
    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    protected Node getRoot() {
        return root;
    }

    public void add(CharSequence word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur.next.putIfAbsent(c, new Node());
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public boolean startsWith(CharSequence prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public boolean contains(CharSequence word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    protected class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node() {
            this(false);
        }

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }
    }

}
