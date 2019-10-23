package com.yan.leetcode.linked;

/**
 * @author Administrator
 * @implSpec <https://leetcode-cn.com/problems/remove-linked-list-elements/>
 * @since 1.0.0
 * 2019/10/18 0018 16:13
 */
public class Solution1 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, 2, 6, 3, 4, 5, 6);
        ListNode listNode1 = new Solution1().removeElements(listNode, 6);
        System.out.println(listNode1);
    }

    @SuppressWarnings("all")
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
