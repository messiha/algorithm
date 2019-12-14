
package src.leetcode;

/**
 * @author yan.zhang
 * @date 2019/8/19 22:52
 */

import src.datastruct.SingleListNode;

/**
 * 翻转链表
 */
public class ReverseLink {

    public static void main(String[] args) {
        SingleListNode n1 = new SingleListNode(1);
        SingleListNode n2 = new SingleListNode(2);
        SingleListNode n3 = new SingleListNode(3);
        n1.next = n2;
        n2.next = n3;

        SingleListNode head = reverseByRecursion(n1);
        System.out.println(head.next.val);
    }

    public static SingleListNode reverseByLoop(SingleListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        SingleListNode p1 = head;
        SingleListNode p2 = head.next;
        SingleListNode temp;
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
    private static SingleListNode reverseByRecursion(SingleListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        SingleListNode newHead = reverseByRecursion(head.next);
        //Node2 指向 Node1
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
