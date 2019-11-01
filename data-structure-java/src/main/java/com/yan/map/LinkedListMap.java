package com.yan.map;

import java.util.Objects;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/31 0031 09:44
 */
@SuppressWarnings("all")
public class LinkedListMap<K, V> implements Map<K, V> {
    private Node dummyHead;
    private int size;

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        Node res = null;
        while (cur != null) {
            if (Objects.equals(cur.key, key)) {
                res = cur;
                break;
            }
            cur = cur.next;
        }
        return res;
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if (null != node) {
            node.value = v;
            return;
        }
        dummyHead.next = new Node(k, v);
        size++;
    }

    @Override
    public V remove(K k) {
        Node node = dummyHead;
        while (node.next != null) {
            if (Objects.equals(node.next.key, k)) {
                break;
            }
            node = node.next;
        }
        if (null == node.next) {
            return null;
        }
        Node preDel = node.next;
        node.next = preDel.next;
        preDel.next = null;
        size--;
        return preDel.value;
    }

    @Override
    public boolean containsKey(K k) {
        return null != getNode(k);
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return null == node ? null : node.value;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if (null == node) {
            throw new IllegalArgumentException(k + " doesn't exist!");
        }
        node.value = v;
    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null);
        }
    }
}
