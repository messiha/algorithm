package src.xmly;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2021/11/24 19:41
 * @Version 1.0
 */
public class LoopListFirstEntry {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        LoopListFirstEntry.find(head);
    }

    private static ListNode find(ListNode head) {
        if (null == head) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;
        while (fast != slow) {
            fast =fast.next;
            slow = slow.next;
        }

        return fast;



    }
}
