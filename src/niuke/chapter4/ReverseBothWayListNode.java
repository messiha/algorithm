/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/16 23:47
 */

import src.datastruct.DoubleListNode;

/**
 * 翻转双向链表
 */
public class ReverseBothWayListNode {

    public static void main(String[] args) {
        //定义双向链表节点
        DoubleListNode b1 = new DoubleListNode(1);
        DoubleListNode b2 = new DoubleListNode(2);
        DoubleListNode b3 = new DoubleListNode(3);

        b1.setNext(b2);
        b2.setPre(b1);
        b2.setNext(b3);
        b3.setPre(b2);

        DoubleListNode newHead = reverseDoubleListNode(b1);
        printDoubleListNode(newHead);
    }

    private static DoubleListNode reverseDoubleListNode(DoubleListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        DoubleListNode p1 = head;
        DoubleListNode p2 = head.next;
        DoubleListNode tmp;
        while (p2 != null) {
            tmp = p2.next;
            p1.pre = p2;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        head.next = null;
        p1.pre = null;
        return p1;
    }


    private static void printDoubleListNode(DoubleListNode head) {
        DoubleListNode end = null;
        while (head != null) {
            System.out.print(head.val + ",");
            end = head;
            head = head.next;
        }
        System.out.print("|");
        while (end != null) {
            System.out.print(end.val + ",");
            end = end.pre;
        }
    }


}
