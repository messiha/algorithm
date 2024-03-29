package src.leetcode;

import src.datastruct.ListNode;

/**
 * @Author yan.zhang
 * @Date 2022/2/23 10:05
 * @Version 1.0
 */
public class AddTwoNumbers {
    /**
     * https://leetcode-cn.com/problems/add-two-numbers/
     * 两数相加
     * <p>
     * 对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点head。
     * 使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(9);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        l2.next.next = new ListNode(4);

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
