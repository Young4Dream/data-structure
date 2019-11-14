package com.yan.tree.leetcode;


import java.util.TreeMap;

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
@SuppressWarnings("all")
class MapSum {

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        add(key, val);
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.val;
        for (char c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }

    protected Node getRoot() {
        return root;
    }

    public void add(CharSequence word, int val) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (null == cur.next.get(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.val = val;
    }


    @SuppressWarnings("all")
    protected class Node {
        public TreeMap<Character, Node> next;
        public int val;

        public Node() {
            this(0);
        }

        public Node(int val) {
            next = new TreeMap<>();
            this.val = val;
        }
    }
}
