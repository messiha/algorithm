package src.off.list;

import src.datastruct.ListNode;

/**
 * @author yan.zhang
 * @date 2020/12/21 14:44
 */
public class DetectCycle {
    /**
     * 对于一个给定的链表，返回环的入口节点，如果没有环，返回null
     * 要求：不使用额外空间
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode l2 = new ListNode(2);
       /* ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);*/

        head.next = l2;


        System.out.println(detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if (fast == null || fast.next == null) {
            return null;
        }

        fast = fast.next.next;
        slow = slow.next;


        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return null;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }

}
