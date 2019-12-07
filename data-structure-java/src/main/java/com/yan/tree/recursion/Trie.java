package com.yan.tree.recursion;

import java.util.TreeMap;

public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public boolean contains(CharSequence sequence) {
        return root != null && root.contains(sequence, root);
    }

    public boolean startsWith(CharSequence sequence) {
        return root != null && root.startsWith(sequence, root);
    }

    public void remove(CharSequence sequence) {
        root = root.remove(sequence, root);
        System.out.println();
    }


    public void add(CharSequence word) {
        root.add(word, root);
    }

    public int size() {
        return root.size;
    }

    static class Node {
        private boolean is_word;
        private int size;
        private TreeMap<Character, Node> map;

        Node() {
            this(false);
        }

        Node(boolean is_word) {
            this.is_word = is_word;
            map = new TreeMap<>();
        }

        private void add(CharSequence sequence, Node node) {
            if (sequence == null || sequence.length() == 0) {
                if (!node.is_word) {
                    node.is_word = true;
                    size++;
                }
                return;
            }
            char first_char = sequence.charAt(0);
            CharSequence other = sequence.subSequence(1, sequence.length());
            node.map.putIfAbsent(first_char, new Node());
            Node next = node.map.get(first_char);
            add(other, next);
        }

        private boolean contains(CharSequence sequence, Node node) {
            if (node == null || sequence == null || sequence.length() == 0) {
                return false;
            }
            char first_char = sequence.charAt(0);
            CharSequence other = sequence.subSequence(1, sequence.length());
            Node next = node.map.get(first_char);
            return (next != null && next.is_word) || contains(other, next);
        }

        private boolean startsWith(CharSequence sequence, Node node) {
            if (node == null || sequence == null || sequence.length() == 0) {
                return true;
            }
            char first_char = sequence.charAt(0);
            CharSequence other = sequence.subSequence(1, sequence.length());
            Node next = node.map.get(first_char);
            return node.map.containsKey(first_char) && startsWith(other, next);
        }

        public Node remove(CharSequence sequence, Node node) {
            if (null == node || sequence.length() == 0) {
                return node;
            }

            char cur_char = sequence.charAt(0);
            CharSequence sub_sequence = sequence.subSequence(1, sequence.length());
            TreeMap<Character, Node> map = node.map;
            if (!map.containsKey(cur_char)) {
                return node;
            }
            if (sub_sequence.length() == 0 && node.is_word) {
                node.is_word = false;
                size--;
                return node;
            }
            Node new_node = remove(sub_sequence, map.get(cur_char));
            node.map.put(cur_char, new_node);
            new_node.map.remove(cur_char);
//            if (new_node.map.size() == 1) {
//                node.map.remove(cur_char);
//                return null;
//            }
            return new_node;
        }
    }


}
