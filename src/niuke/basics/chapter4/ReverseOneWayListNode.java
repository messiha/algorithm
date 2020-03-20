/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/16 23:46
 */

import src.datastruct.ListNode;

/**
 * 翻转单向链表
 */
public class ReverseOneWayListNode {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode head = reverseByLoop(n1);
        System.out.println(head.next.val);
    }

    public static ListNode reverseByLoop(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode tmp = null;
        while (p2 != null) {
            tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        head.next = null;
        return p1;
    }


    public static ListNode reverseByRecursion(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode newHead = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
