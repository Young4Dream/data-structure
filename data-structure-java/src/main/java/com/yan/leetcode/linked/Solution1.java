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
        ListNode listNode1 = new Solution1().removeFirstElement(listNode, 6);
        System.out.println(listNode1);
//        System.out.println(sum(1, 1, 1));
    }

//    public static int sum(int... ints) {
//        return sum(0, ints);
//    }
//
//    private static int sum(int index, int[] ints) {
//        if (index == ints.length) {
//            return 0;
//        }
//        if (false) {
//            return 0;
//        }
//        int sum = ints[index] + sum(index + 1, ints);
//        return sum;
//    }

    @SuppressWarnings("all")
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    @SuppressWarnings("all")
    public ListNode removeFirstElement(ListNode node, int val) {
        if (node == null) return null;
        if (node.val == val) {
            return node.next;
        }
        node.next = removeFirstElement(node.next, val);
        return node;
    }
}
