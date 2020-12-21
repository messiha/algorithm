package src.off.list;

import src.datastruct.ListNode;

/**
 * @author yan.zhang
 * @date 2020/12/18 15:33
 */
public class MergeTwoList {
    /**
     * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的，且合并后新链表依然有序。
     */
    public static void main(String[] args) {
        /*ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(4);
        ListNode t3 = new ListNode(6);
        t1.next = t2;
        t2.next = t3;*/


        ListNode n1 = new ListNode(7);
        ListNode n2 = new ListNode(4);

        n1.next = n2;

        ListNode t1 = new ListNode(3);

        ListNode newHead = mergeTwoLists(n1, t1);
        System.out.println(newHead);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode res;

        if (l1.val < l2.val) {
            res = l1;
            res.next = mergeTwoLists(l1.next, l2);
        } else {
            res = l2;
            res.next = mergeTwoLists(l1, l2.next);
        }
        return res;
    }
}
