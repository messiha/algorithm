package src.exercise;

import src.datastruct.ListNode;

/**
 * @author yan
 * @date 2020/6/2612:56
 */
public class PalindromeList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        /*head.next = new SingleListNode(2);
        head.next.next = new SingleListNode(3);
        head.next.next.next = new SingleListNode(2);
        head.next.next.next.next = new SingleListNode(1);*/


        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(IsPalindrome2(head));

    }

    private static boolean IsPalindrome2(ListNode head) {
        return false;
    }

    private static ListNode reverseLinkListByRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseLinkListByRecur(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
