package src.leetcode.list;

import src.datastruct.ListNode;

/**
 * @author yan.zhang
 * @date 2022/4/19 22:49
 */
public class ReorderList {
    /**
     * 重排链表
     * https://leetcode-cn.com/problems/reorder-list/
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        head.next = n2;
        n2.next = n3;
        n3.next = n4;

        reorder(head);
    }

    private static void reorder(ListNode head) {
        //快慢指针找出中心点
        ListNode middle = middleNode_0(head);

        ListNode l1 = head;
        ListNode l2 = reverse(middle.next);
        middle.next = null;
        //连接
        while (l1 != null && l2 != null) {
            ListNode t1 = l1.next;
            ListNode t2 = l2.next;
            l1.next = l2;
            l2.next = t1;
            l1 = t1;
            l2 = t2;
        }
    }

    private static ListNode reverse(ListNode middle) {
        if (middle == null || middle.next == null) {
            return middle;
        }
        ListNode newNode = reverse(middle.next);
        middle.next.next = middle;
        middle.next = null;
        return newNode;
    }

    private static ListNode middleNode_0(ListNode node) {
        ListNode quick = node;
        ListNode slow = node;
        while (quick.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }



    private static ListNode middleNode(ListNode node) {
        ListNode quick = node;
        ListNode slow = node;
        while (quick != null) {
            if (quick.next == null) {
                break;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return slow;
    }
}
