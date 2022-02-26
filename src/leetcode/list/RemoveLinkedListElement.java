package src.leetcode.list;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2022/2/26 17:10
 * @Version 1.0
 */
public class RemoveLinkedListElement {
    /**
     * https://leetcode-cn.com/problems/remove-linked-list-elements/
     * 移除链表元素
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        solution(head, 7);
    }

    private static ListNode solution(ListNode head, int val) {
        if (null == head) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur != null) {
            if (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
            } else if (cur.val == val) {
                dummy.next = cur.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
