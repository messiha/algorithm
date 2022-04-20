package src.leetcode.list;

import src.datastruct.ListNode;

/**
 * @author yan.zhang
 * @date 2022/4/20 12:05
 */
public class SortList02 {
    public static void main(String[] args) {
        ListNode h1 = new ListNode(3);
        h1.next = new ListNode(1);
        h1.next.next = new ListNode(2);
        h1.next.next.next = new ListNode(0);

        ListNode h2 = new ListNode(-1);
        h2.next = new ListNode(-4);
        h2.next.next = new ListNode(5);
        h2.next.next.next = new ListNode(4);

        sort(h1);
    }

    /**
     * 递归过程中使用快慢指针的方式将链表分割成两部分
     * 空间复杂度：O(log n)
     *
     * @param head
     * @return
     */
    private static ListNode sort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode split = split(head);
        ListNode pre = sort(head);
        ListNode last = sort(split);
        return merge(pre, last);
    }

    private static ListNode merge(ListNode pre, ListNode last) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (pre != null && last != null) {
            if (pre.val < last.val) {
                cur.next = pre;
                pre = pre.next;
            } else {
                cur.next = last;
                last = last.next;
            }
            cur = cur.next;
        }

        if (pre != null) {
            cur.next = pre;
        }
        if (last != null) {
            cur.next = last;
        }
        return dummy.next;
    }

    /**
     * 分割链表
     *
     * @param head
     * @return
     */
    private static ListNode split(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode result = slow.next;
        slow.next = null;
        return result;
    }



}
