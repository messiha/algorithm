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

        ListNode sn = solution(h1);


        bubbleSortByList(h1);
        bubbleSortByList(h2);

        ListNode node = merge(h1, h2);
        System.out.println(node);

    }

    //先两个两个的 merge，完成一趟后，再 4 个4个的 merge，直到结束。
    private static ListNode solution(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode work = head;
        int len = 0;
        while (work != null) {
            ++len;
            work = work.next;
        }

        ListNode tail;
        for (int size = 1; size < len; size <<= 1) {
            work = dummy.next;
            tail = dummy;

            while (work != null) {
                ListNode left = work;
                //将链表拆成两部分，左边为step长链表，右边为剩余链表
                ListNode right = cut(left, size);
                //这步执行完毕，left为step链表，right为step链表，work为剩余链表，下一趟排序的基础链表
                work = cut(right, size);

                tail.next = merge(left, right);

                while (tail.next != null) {
                    tail = tail.next;
                }
            }
        }
        return dummy.next;
    }

    /**
     * 链表切掉size个节点，返回后半部分的链表头
     *
     * @param head
     * @param size
     * @return
     */
    private static ListNode cut(ListNode head, int size) {
        while (--size != 0 && head != null) {
            head = head.next;
        }
        if (head != null) {
            ListNode result = head.next;
            head.next = null;
            return result;
        } else {
            return null;
        }
    }

    /**
     * 归并两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }

        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }

        return dummy.next;
    }

    private static ListNode mergeByRecur(ListNode h1, ListNode h2) {
        if (null == h1) {
            return h2;
        }
        if (null == h2) {
            return h1;
        }

        ListNode head;
        if (h1.val > h2.val) {
            head = h2;
            head.next = mergeByRecur(h1, h2.next);
        } else {
            head = h1;
            head.next = mergeByRecur(h1.next, h2);
        }
        return head;
    }


    //冒泡
    private static ListNode bubbleSortByList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head, p2;
        for (; p1.next != null; p1 = p1.next) {
            for (p2 = head; p2.next != null; p2 = p2.next) {
                if (p2.val > p2.next.val) {
                    swap(p2, p2.next);
                }

            }
        }
        return head;
    }

    //插入
    private static ListNode insertSortByList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0), pre;
        dummy.next = head;

        while (head.next != null) {
            if (head.val <= head.next.val) {
                head = head.next;
                continue;
            }
            pre = dummy;

            while (pre.next.val < head.next.val) {
                pre = pre.next;
            }

            ListNode curr = head.next;
            head.next = curr.next;
            curr.next = pre.next;
            pre.next = curr;
        }
        return dummy.next;
    }

    //归并


    //直接换值
    private static void swap(ListNode cur, ListNode next) {
        int tmp = cur.val;
        cur.val = next.val;
        next.val = tmp;
    }

}
