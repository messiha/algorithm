package src.xmly;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2021/11/22 16:51
 * @Version 1.0
 */
public class LinkedListCommonPart {
    public static void main(String[] args) {
        ListNode common1 = new ListNode(8);
        ListNode common2 = new ListNode(9);
        ListNode h1 = new ListNode(1);
        h1.next = common1;
        ListNode h2 = new ListNode(3);
        h2.next = common1;
        common1.next = common2;
        LinkedListCommonPart.commonPart(h1, h2);
    }

    private static void commonPart(ListNode h1, ListNode h2) {
        ListNode p1 = h1;
        ListNode p2 = h2;

        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p1 = p1.next;
            } else if (p1.val > p2.val) {
                p2 = p2.next;
            } else {
                System.out.println(p1.val);
                p1 = p1.next;
                p2 = p2.next;
            }
        }
    }
}
