package src.leetcode.list;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2021/11/26 17:04
 * @Version 1.0
 */
public class SwapNodeInPairs {
    /**
     * 链表相邻节点反转
     * 1->2->3->4->5
     * 2->1->4->3->5
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode newH = SwapNodeInPairs.solution(head);
        while (newH != null) {
            System.out.println(newH.val);
            newH = newH.next;
        }
    }

    private static ListNode solutionByRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next.next;
        ListNode newHead = head.next;
        newHead.next = head;
        head.next = solutionByRecur(tmp);
        return newHead;
    }

    private static ListNode solution(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode start = new ListNode(0);
        start.next = head;
        for (ListNode cur = start; cur.next != null && cur.next.next != null; cur = cur.next.next) {
            cur.next = swap(cur.next, cur.next.next);
        }

        return start.next;
    }

    private static ListNode swap(ListNode next, ListNode later) {
        next.next = later.next;
        later.next = next;
        return later;
    }
}
