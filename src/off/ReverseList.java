/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/3/19 21:32
 */

import src.datastruct.ListNode;

/**
 * 反转链表:输入一个链表，反转链表后，输出新链表的表头。
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

//        SingleListNode head1 = reverseByRecursion(n1);
        ListNode head2 = reverseByPoint(n1);
        System.out.println(head2.next.next.val);
    }

    private static ListNode reverseByPoint(ListNode head) {
        if (head == null || head.next == null) {
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

    private static ListNode reverseByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
