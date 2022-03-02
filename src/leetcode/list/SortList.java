package src.leetcode.list;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2022/3/2 16:10
 * @Version 1.0
 */
public class SortList {
    /**
     * https://leetcode-cn.com/problems/sort-list/
     * 排序链表
     */
    public static void main(String[] args) {
        ListNode h1 = new ListNode(3);
        h1.next = new ListNode(1);
        h1.next.next = new ListNode(2);
        h1.next.next.next = new ListNode(0);

        ListNode h2 = new ListNode(-1);
        h2.next = new ListNode(-4);
        h2.next.next = new ListNode(5);
        h2.next.next.next = new ListNode(4);

        bubbleSortByList(h1);
        bubbleSortByList(h2);

        ListNode node = merge(h1, h2);
        System.out.println(node);

    }

    private static ListNode merge(ListNode h1, ListNode h2) {
        if (null == h1) {
            return h2;
        }
        if (null == h2) {
            return h1;
        }

        ListNode head;
        if (h1.val > h2.val) {
            head = h2;
            head.next = merge(h1, h2.next);
        } else {
            head = h1;
            head.next = merge(h1.next, h2);
        }
        return head;
    }

    //冒泡
    private static ListNode bubbleSortByList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head, p2 = head;
        for (; p1.next != null; p1 = p1.next) {
            for (p2 = head; p2.next != null; p2 = p2.next) {
                if (p2.val > p2.next.val) {
//                    swap(p2, p2.next);
                }

            }
        }
        return head;
    }

    //直接换值
    /*private static void swap(ListNode cur, ListNode next) {
        int tmp = cur.val;
        cur.val = next.val;
        next.val = tmp;
    }*/

}
