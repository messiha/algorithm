/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/3/19 22:07
 */

import src.datastruct.ListNode;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoOfIncreaseList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode t1 = new ListNode(2);
        ListNode t2 = new ListNode(4);
        ListNode t3 = new ListNode(6);
        t1.next = t2;
        t2.next = t3;

        ListNode listNode = mergeByPoint(n1, t1);
        System.out.println();
//        ListNode listNode = mergeByRecur(n1, t1);

    }

    private static ListNode mergeByRecur(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode res;
        if (list1.val < list2.val) {
            res = list1;
            res.next = mergeByRecur(list1.next, list2);
        } else {
            res = list2;
            res.next = mergeByRecur(list1, list2.next);
        }
        return res;
    }

    /**
     * 思路:
     * 每次将val较小的node串接起来，较大的node指针保持不动
     */
    public static ListNode mergeByPoint(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode cur = null;
        ListNode mergeHead = null;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                if (mergeHead == null) {
                    //第一次进入循环 mergeHead = list1
                    mergeHead = cur = list1;
                } else {
                    //将较小的node 的 next指针指向 list2 ,lists2保持不变
                    cur.next = list1;
                    cur = cur.next;

                }
                list1 = list1.next;
            } else {
                if (mergeHead == null) {
                    mergeHead = cur = list2;
                } else {
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return mergeHead;
    }
}
