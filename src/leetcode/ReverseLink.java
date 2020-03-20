
package src.leetcode;

/**
 * @author yan.zhang
 * @date 2019/8/19 22:52
 */

import src.datastruct.ListNode;

/**
 * 翻转链表
 */
public class ReverseLink {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode head = reverseByRecursion(n1);
        System.out.println(head.next.val);
    }

    public static ListNode reverseByLoop(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode temp;
        while (null != p2) {
            //定义临时指针temp 指p2.next
            temp = p2.next;
            //将Node2 指向 Node1
            p2.next = p1;
            p1 = p2;
            //p2指针向后移动
            p2 = temp;
        }
        head.next = null;
        return p1;
    }


    //递归方式翻转
    private static ListNode reverseByRecursion(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode newHead = reverseByRecursion(head.next);
        //Node2 指向 Node1
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
