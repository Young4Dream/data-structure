package com.yan.linked;

import java.util.StringJoiner;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/17 0017 19:19
 */
@SuppressWarnings("all")
public class LinkedList<E> extends AbstractLinkedList<E> {
    public LinkedList() {
        // 新增虚拟头结点
        head = new Node(null, null);
        size = 0;
    }

    public void removeElement(E e) {
        Node cur = head.next;
        while (cur != null) {
            Node next = cur.next;
            if (null != next && next.e.equals(e)) {
                cur.next = next.next;
                size--;
                return;
            }
            cur = next;
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", LinkedList.class.getSimpleName() + "[", "]");
        StringJoiner eleStringJoiner = new StringJoiner(", ", LinkedList.Node.class.getSimpleName() + "[", "]");
        Node cur = head.next;
        while (cur != null) {
            eleStringJoiner.add(cur.toString());
            cur = cur.next;
        }
        return stringJoiner
                .add("elements=" + eleStringJoiner)
                .add("size=" + size)
                .toString();
    }

    /**
     * 修改index位置的元素为e
     *
     * @param index 索引
     * @param e     元素
     */
    @Override
    public void update(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index~");
        }
        Node cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    /**
     * 插入元素，一般不用
     *
     * @param index 索引
     * @param e     元素
     */
    protected void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Illegal index.");
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    public void add(E e) {
        addLast(e);
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node cur = prev.next;
        prev.next = cur.next;
        cur.next = null;
        size--;
        return true;
    }

    public E get(int index) {
        Node cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getLast() {
        return get(size - 1);
    }

    public boolean contains(E e) {
        Node cur = head.next;
        while (null != cur) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
}
