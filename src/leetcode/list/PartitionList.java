package src.leetcode.list;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2022/3/11 15:52
 * @Version 1.0
 */
public class PartitionList {
    /**
     * 分隔链表
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        ListNode node = partition(head, 3);

    }

    private static ListNode partition(ListNode head, int x) {
        ListNode dummy1 =  new ListNode(-1,head);
        //后半部分
        ListNode dummy2 =  new ListNode(-1,head);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        while (null != head) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }

        if (p1.next == null) {
            p2.next = null;
        }
        if (p2.next == null) {
            p1.next = null;
        }
        p1.next = dummy2.next;

        return dummy1.next;
    }
}
