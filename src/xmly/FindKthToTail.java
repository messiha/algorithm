package src.xmly;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2021/11/24 20:01
 * @Version 1.0
 */
public class FindKthToTail {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        FindKthToTail.find(head, 3);
    }

    private static ListNode find(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (k != 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            k--;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }
}
