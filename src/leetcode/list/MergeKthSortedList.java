package src.leetcode.list;

import src.datastruct.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yan.zhang
 * @date 2022/3/6 10:22
 */
public class MergeKthSortedList {
    /**
     * https://leetcode-cn.com/problems/merge-k-sorted-lists/
     * 合并K个升序链表
     */
    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        lists[0] = l1;
        lists[1] = l2;
        lists[2] = l3;

//        mergeByPriorityQueue(lists);
//        merge_02(lists);
        mergeByDivide(lists, 0, lists.length - 1);
    }

    /**
     * 借助优先级队列实现
     *
     * @param lists
     * @return
     */
    private static ListNode mergeByPriorityQueue(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));

        //头结点放入
        for (ListNode node : lists) {
            if (null != node) {
                queue.offer(node);
            }
        }
        //弹出最小
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            if (null != node.next) {
                queue.offer(node.next);
            }
            cur.next = node;
            cur = cur.next;
        }

        return dummy.next;
    }


    /**
     * 将合并k个链表，转换为，合并2个链表k-1次
     *
     * @param lists
     * @param left
     * @param right
     * @return 返回left，right合并后的头结点
     */
    private static ListNode mergeByDivide(ListNode[] lists, int left, int right) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        return mergeByDivide0(lists, left, right);
    }

    private static ListNode mergeByDivide0(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + ((right - left) >> 1);
        return merge(mergeByDivide0(lists, left, mid), mergeByDivide0(lists, mid + 1, right));
    }

    private static ListNode merge_02(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }
        int len = lists.length;
        for (int step = 1; step < len; step <<= 1) {
            for (int i = 0; i + step <= len - 1; i += step * 2) {
                ListNode first = lists[i], second = lists[i + step];
                lists[i] = merge(first, second);
            }
        }
        return lists[0];
    }

    private static ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                cur.next = left;
                cur = cur.next;
                left = left.next;
            } else {
                cur.next = right;
                cur = cur.next;
                right = right.next;
            }
        }

        if (left == null) {
            cur.next = right;
        }

        if (right == null) {
            cur.next = left;
        }

        return dummy.next;
    }
}
