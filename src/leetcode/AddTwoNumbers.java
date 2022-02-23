package src.leetcode;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2022/2/23 10:05
 * @Version 1.0
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(6);
//      l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(6);
        l2.next = new ListNode(1);
//      l2.next.next = new ListNode(4);

        solution(l1, l2);
    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        ListNode dummy, cur;
        dummy = cur = new ListNode(0);
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;

            int sum = x + y + carry;
            carry = sum / 10;

            cur.next = new ListNode(sum % 10);
            cur = cur.next;


            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

            if (carry == 1) {
                cur.next = new ListNode(carry);
            }
        }

        return dummy.next;
    }
}
