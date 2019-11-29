package com.yan.leetcode.linked;

import java.util.StringJoiner;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/10/18 0018 16:14
 */
class ListNode {
    int val;
    ListNode next;

    @SuppressWarnings("all")
    ListNode(int x) {
        val = x;
    }

    ListNode(int init, int... ints) {
        this.val = init;
        ListNode prev = this;
        for (int i : ints) {
            prev = prev.next = new ListNode(i);
        }
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]").add(String.valueOf(val));
        for (ListNode next = this.next; next != null; next = next.next) {
            stringJoiner.add(String.valueOf(next.val));
        }
        return stringJoiner.toString();
    }
}
