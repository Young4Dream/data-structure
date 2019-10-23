package com.yan.leetcode.linked;

/**
 * @author Administrator
 * @implSpec <https://leetcode-cn.com/problems/remove-linked-list-elements/>
 * @since 1.0.0
 * 2019/10/18 0018 16:13
 */
public class Solution {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, 2, 6, 3, 4, 5, 6);
        new Solution().removeElements(listNode, 6);
    }

    @SuppressWarnings("all")
    public ListNode removeElements(ListNode head, int val) {
        ListNode delNode = head;
        while (head != null && head.val == val) {
            head = head.next;
            delNode.next = null;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while (null != prev.next) {
            if (prev.next.val == val) {
                delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else
                prev = prev.next;
        }
        return head;
    }
}
