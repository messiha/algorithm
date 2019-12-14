/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/26 16:12
 */

import src.datastruct.SingleListNode;

/**
 * 打印两个有序链表的公共部分
 * 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 */
public class PrintLinkedCommonPart {
    private static void printCommonPart(SingleListNode h1, SingleListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                h2 = h2.next;
            } else if (h1.val < h2.val) {
                h1 = h1.next;
            } else {
                //值相等 同时移动
                System.out.print(h1.val);
                h1 = h1.next;
                h2 = h2.next;
            }
        }
    }

    public static void main(String[] args) {
        SingleListNode h1 = new SingleListNode(1);
        h1.next = new SingleListNode(2);
        h1.next.next = new SingleListNode(3);

        SingleListNode h2 = new SingleListNode(3);
        h2.next = new SingleListNode(4);
        h2.next.next = new SingleListNode(5);

        printLinkedList(h1);
        printLinkedList(h2);
        printCommonPart(h1, h2);
    }

    private static void printLinkedList(SingleListNode h2) {
        System.out.print("Linked List: ");
        while (h2 != null) {
            System.out.print(h2.val);
            h2 = h2.next;
        }
        System.out.println();
    }


}
