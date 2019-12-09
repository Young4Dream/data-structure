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
        private TreeMap<Character, Node> chars;

        Node() {
            this(false);
        }

        Node(boolean is_word) {
            this.is_word = is_word;
            chars = new TreeMap<>();
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
            node.chars.putIfAbsent(first_char, new Node());
            add(other, node.chars.get(first_char));
        }

        private boolean contains(CharSequence sequence, Node node) {
            if (node == null || sequence == null || sequence.length() == 0) {
                return false;
            }
            char first_char = sequence.charAt(0);
            CharSequence other = sequence.subSequence(1, sequence.length());
            Node next = node.chars.get(first_char);
            return (next != null && next.is_word && next.chars.size() >= other.length()) || contains(other, next);
        }

        private boolean startsWith(CharSequence sequence, Node node) {
            if (node == null || sequence == null || sequence.length() == 0) {
                return true;
            }
            char first_char = sequence.charAt(0);
            CharSequence other = sequence.subSequence(1, sequence.length());
            Node next = node.chars.get(first_char);
            return node.chars.containsKey(first_char) && startsWith(other, next);
        }

        public Node remove(CharSequence sequence, Node node) {
            if (null == node || sequence.length() == 0) {
                return node;
            }
            TreeMap<Character, Node> chars = node.chars;
            char cur_char = sequence.charAt(0);
            if (!chars.containsKey(cur_char)) {
                return node;
            }
            Node next = chars.get(cur_char);
            CharSequence sub_sequence = sequence.subSequence(1, sequence.length());
            if (sub_sequence.length() == 0 && next.is_word) {
                next.is_word = false;
                size--;
                return node;
            }
            chars.put(cur_char, remove(sub_sequence, next));
            if (sub_sequence.length() > 0) {
                char key = sub_sequence.charAt(0);
                Node next_next = next.chars.get(key);
                if (!next_next.is_word && next_next.chars.isEmpty()) {
                    next.chars.remove(key);
                }
            }
            return node;
        }

        /**
         * teacher's code.
         *
         * @see #remove(CharSequence, Node)
         * @deprecated
         */
        private boolean remove(Node node, String word, int index) {
            if (index == word.length()) {
                if (!node.is_word)
                    return false;
                node.is_word = false;
                size--;
                return true;
            }

            char c = word.charAt(index);
            if (!node.chars.containsKey(c))
                return false;

            boolean ret = remove(node.chars.get(c), word, index + 1);
            Node nextNode = node.chars.get(c);
            if (!nextNode.is_word && nextNode.chars.size() == 0)
                node.chars.remove(word.charAt(index));
            return ret;
        }
    }

}
