package src.xmly;

import src.datastruct.DoubleListNode;
import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2021/11/22 17:07
 * @Version 1.0
 */
public class LinkedListReverse {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        //单向链表反转
        ListNode listNode = LinkedListReverse.reverseByRecursive(n1);
        System.out.println(listNode);
        LinkedListReverse.reverseByTravel_01(n1);
        LinkedListReverse.reverseByTravel_02(n1);

        //定义双向链表节点
        DoubleListNode b1 = new DoubleListNode(1);
        DoubleListNode b2 = new DoubleListNode(2);
        DoubleListNode b3 = new DoubleListNode(3);

        b1.setNext(b2);
        b2.setPre(b1);
        b2.setNext(b3);
        b3.setPre(b2);
    }

    private static ListNode reverseByTravel_01(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode tmp;
        while (p2 != null) {
            tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        head.next = null;
        return p1;
    }

    private static ListNode reverseByTravel_02(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode next = null;
        ListNode pre = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private static ListNode reverseByRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = reverseByRecursive(head.next);
        head.next.next = head;
        head.next = null;
        return next;
    }
}
