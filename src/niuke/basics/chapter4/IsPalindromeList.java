/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/26 16:16
 */

import src.datastruct.SingleListNode;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * 给定一个链表头节点
 * <p>
 * 思路1：使用额外空间，第一次遍历将链表数据入栈，第二遍每次遍历和栈弹出的值比对
 * <p>
 * 思路2：不使用额外空间解法
 * 快慢指针，快指针到终点位置，慢指针在中点位置，反转慢指针后半部分链表，头指针head向后遍历，尾指针(慢指针)向前,
 * 到中点停止，比较这个过程中的每一个值是否相等，最后将链表恢复初始状态
 */
public class IsPalindromeList {
    public static void main(String[] args) {
        SingleListNode head = new SingleListNode(1);
        /*head.next = new SingleListNode(2);
        head.next.next = new SingleListNode(3);
        head.next.next.next = new SingleListNode(2);
        head.next.next.next.next = new SingleListNode(1);*/


        head.next = new SingleListNode(2);
        head.next.next = new SingleListNode(2);
        head.next.next.next = new SingleListNode(1);

        System.out.println(IsPalindrome2(head));

    }

    /**
     * 方式2
     * need O(1) extra space
     */
    private static boolean IsPalindrome2(SingleListNode head) {
        if (null == head || head.next == null) {
            return true;
        }
        SingleListNode fast = head;
        SingleListNode slow = head;
        //fast.next.next != null   保证不会为null fast = fast.next.next;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next; //slow>mid
            fast = fast.next.next;//fast>end
        }
        SingleListNode tmp = slow;

        //以slow为head 翻转链表
        SingleListNode tailHead = reversLink(tmp);

        //判断是否为回文链表
        SingleListNode right = head;
        SingleListNode left = head;
        boolean res = true;
        while (left != null && right != null) {
            if (left.val != right.val) {
                res = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        //右半部分复原
        reversLink(tailHead);
        return res;
    }


    /**
     * 方式1
     * need N extra space
     */
    private static boolean IsPalindrome1(SingleListNode head) {
        Stack<SingleListNode> stack = new Stack<>();
        SingleListNode cur = head;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    private static SingleListNode reversLink(SingleListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SingleListNode newHead = reversLink(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
