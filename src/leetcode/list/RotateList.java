package src.leetcode.list;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2022/2/25 14:11
 * @Version 1.0
 */
public class RotateList {
    /**
     * https://leetcode-cn.com/problems/rotate-list/
     * 旋转链表
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);

        solution(head, 4);
    }

    private static ListNode solution(ListNode head, int k) {
        if (null == head || head.next == null || k == 0) {
            return head;
        }
        int len = 1;
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        int offset = k % len;

        if (offset == 0) {
            return head;
        }

        tail.next = head;

        //定位倒数第offset的节点,此节点为头节点，倒数第offset+1的节点为尾节点
        for (int i = 0; i < len - offset; i++) {
            tail = tail.next;
        }

        ListNode newHead = tail.next;
        tail.next = null;
        return newHead;
    }


}
