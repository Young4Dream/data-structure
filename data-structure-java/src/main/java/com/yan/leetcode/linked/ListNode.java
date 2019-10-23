package com.yan.leetcode.linked;

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
}
