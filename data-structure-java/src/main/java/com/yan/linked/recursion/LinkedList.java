package com.yan.linked.recursion;

import com.yan.linked.AbstractLinkedList;

import java.util.Objects;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/22 0022 10:11
 */
public class LinkedList<E> extends AbstractLinkedList<E> {

    @Override
    public E get(int index) {
        return get(head, 0, index);
    }

    private E get(Node node, int i, int index) {
        if (i == index) {
            return node.e;
        }
        return get(node.next, ++i, index);
    }

    @Override
    public void add(E e) {
        insert(size, e);
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        if (index == 0) {
            size--;
            head = head.next;
            return true;
        }
        return remove(head, 0, index);
    }

    private boolean remove(Node node, int i, int index) {
        if (i + 1 == index) {
            size--;
            node.next = node.next == null ? null : node.next.next;
            return true;
        }
        return remove(node.next, ++i, index);
    }

    private Node remove(Node node, E e) {
        if (null == node) {
            return null;
        }
        node.next = remove(node.next, e);
        if (Objects.equals(node.e, e)) {
            size--;
            return node.next;
        }
        return node;
    }

    @Override
    public void removeElement(E ele) {
        remove(head, ele);
    }

    @Override
    public void update(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Illegal index!");
        }
        if (index == 0) {
            head.e = e;
            return;
        }
        update(head, 0, index, e);
    }

    private void update(Node node, int i, int index, E e) {
        if (i == index) {
            node.e = e;
            return;
        }
        update(node.next, ++i, index, e);
    }

    @Override
    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (Objects.equals(node.e, e)) {
            return true;
        }
        return contains(node.next, e);
    }

    @Override
    protected void insert(int index, E e) {
        insert(head, 0, index, e);
    }

    private void insert(Node node, int i, int index, E e) {
        if (index == 0) {
            size++;
            head = new Node(e, head);
            return;
        }
        if (i == index - 1) {
            size++;
            node.next = new Node(e, node.next);
            return;
        }
        insert(node.next, ++i, index, e);
    }
}
