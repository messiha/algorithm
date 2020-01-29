/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter4;

/**
 * @author yan.zhang
 * @date 2019/12/7 19:09
 */

import src.datastruct.SingleListNode;

/**
 * 两个单链表相交的问题
 * 问题：单链表可能有环，可能无环。给定两个单链表的头节点，head1和head2，两个链表可能相交，也可能不相交，请实现一个函数
 * 如果链表相交请返回相交的第一个节点，如果不相交返回null，要求：如果链表1长度为N,链表2长度为M，时间复杂度达到O(N+M),额外空间
 * 复杂度O(1)
 */
public class FindFirstNode {

    public static SingleListNode getIntersectNode(SingleListNode head1, SingleListNode head2) {
        if (null == head1 || null == head2) {
            return null;
        }
        //判断链表是否有环，若有，返回第一个入环Node
        SingleListNode loop1 = getFirstLoopNode(head1);
        SingleListNode loop2 = getFirstLoopNode(head2);

        if (loop1 == null && loop2 == null) {
            //两个无环链表
            return noLoop(head1, head2);
        }
        if (loop1 != null && loop2 != null) {
            //两个有环链表，分三种情况
            return bothLoop(head1, loop1, head2, loop2);
        }
        //一个有环，一个无环
        return null;
    }

    private static SingleListNode noLoop(SingleListNode head1, SingleListNode head2) {
        //算出长度和最后一个Node
        SingleListNode cur1 = head1;
        SingleListNode cur2 = head2;
        int n = 0;//两个链表长度差值
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //若两个链表最后的Node不相等，则一定不相交,若最后Node相等则相交
        if (cur1 != cur2) {
            return null;
        }
        //
        cur1 = n > 0 ? head1 : head2;//cur1指向长链表
        cur2 = cur1 == head1 ? head2 : head1;//cur2必定指向head1或head2
        n = Math.abs(n);
        //长链表先走n
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        //长短链表一起走
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    /**
     * 都有环
     * 1.loop1==loop2 相交
     * 2.如果
     */
    private static SingleListNode bothLoop(SingleListNode head1, SingleListNode loop1, SingleListNode head2, SingleListNode loop2) {
        SingleListNode cur1 = head1;
        SingleListNode cur2 = head2;
        if (loop1 == loop2) {
            //一定相交，返回第一个交点，转换成单链表相交问题
            return noLoop(head1, head2);
        }
        //
        cur1 = loop1.next;
        //如果cur1转回到loop1处仍然没有遇到loop2认为 两个链表没有相交
        while (cur1 != loop1) {
            if (cur1 == loop2) {
                return loop1;
            }
        }
        return null;
    }

    /**
     * 若链表有环，返回入环第一个Node
     * 1.快，慢指针
     * 2.hashSet
     */
    private static SingleListNode getFirstLoopNode(SingleListNode head) {
        //快指针next过程中遇到null，返回无环，有环链表不会为null，若有环，快指针和慢指针一定在环上相遇
        //相遇时刻 快指针回到head，快指针一次走一步，快慢指针一定在入环节点相遇(数学归纳法证明)
        SingleListNode n1 = head; //slow
        SingleListNode n2 = head; //fast

        while (n1 != n2) {
            if (n2.next == null || n1.next.next == null) {
                return null;
            }
            n1 = n1.next;
            n2 = n2.next.next;
        }
        //fast指针回到头，快慢指针每次走一步，再次相遇的node，是第一个入环的节点
        n2 = head;
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public static void main(String[] args) {

    }
}
