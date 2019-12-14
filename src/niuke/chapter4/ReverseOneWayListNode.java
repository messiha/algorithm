/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/16 23:46
 */

import src.datastruct.SingleListNode;

/**
 * 翻转单向链表
 */
public class ReverseOneWayListNode {
    public static void main(String[] args) {
        SingleListNode n1 = new SingleListNode(1);
        SingleListNode n2 = new SingleListNode(2);
        SingleListNode n3 = new SingleListNode(3);
        n1.next = n2;
        n2.next = n3;
        SingleListNode head = reverseByLoop(n1);
        System.out.println(head.next.val);
    }

    public static SingleListNode reverseByLoop(SingleListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        SingleListNode p1 = head;
        SingleListNode p2 = head.next;
        SingleListNode tmp = null;
        while (p2 != null) {
            tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        head.next = null;
        return p1;
    }


    public static SingleListNode reverseByRecursion(SingleListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        SingleListNode newHead = reverseByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
