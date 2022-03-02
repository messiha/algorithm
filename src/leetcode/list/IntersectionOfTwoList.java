package src.leetcode.list;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2022/3/1 10:22
 * @Version 1.0
 */
public class IntersectionOfTwoList {
    /**
     * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/comments/
     * 链表相交
     */
    public static void main(String[] args) {
        ListNode h1 = new ListNode(3);
        ListNode h2 = new ListNode(2);
        h2.next = new ListNode(3);
        h2.next.next = h1;

        ListNode node = getIntersectionNode(h1, h2);
        System.out.println(node.val);
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }
            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }

        }

        return pA;


    }
}
