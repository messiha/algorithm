package src.leetcode;

import src.datastruct.ListNode;

/**
 * @author yan.zhang
 * @date 2022/2/24 23:14
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/submissions/
     * 删除链表倒数第N个节点
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        solution(head, 1);
    }

    private static ListNode solution(ListNode head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode quick = head;
        //slow = dummy;当慢指针停下时，为要删除的节点的前驱结点
        ListNode slow = dummy;

        for (int i = 0; i < n; i++) {
            quick = quick.next;
        }

        while (quick != null) {
            quick = quick.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
