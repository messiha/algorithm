/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/27 14:18
 */

import src.datastruct.ListNode;

/**
 * 单项链表荷兰旗问题
 * <p>
 * 将单链表划分成左边小，中间相等，右边大的形式
 * 题目：给定单项链表头head，节点值类型是整形，在给定一个数，对调整后的节点顺序没有要求。
 * 例如9>0>4>5>1 pivot=3,调整后链表可以是1>0>4>9>5也可以是0>1>9>5>4
 */
public class ListHollandFlag {
    public static void main(String[] args) {
        ListNode head = new ListNode(9);
        head.next = new ListNode(0);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(3);
        int pivot = 3;
        ListNode newHead = listPartition(head, pivot);
    }

    //使用辅助数组
    private static ListNode listPartition(ListNode head, int pivot) {
        ListNode cur = head;
        int arrLength = 0;
        while (cur != null) {
            arrLength++;
            cur = cur.next;
        }
        ListNode[] nodeArr = new ListNode[arrLength];
        //将链表node放入 nodeArr
        cur = head;
        for (int i = 0; i < arrLength; i++) {
            nodeArr[i] = cur;
            cur = cur.next;
        }
        nodeArrPartition(nodeArr, pivot);
        //将数组中的node串成链表
        int i = 1;
        for (; i < arrLength; i++) {
            nodeArr[i - 1].next = nodeArr[i];
        }
        nodeArr[i - 1].next = null;
        return nodeArr[0];
    }


    private static void nodeArrPartition(ListNode[] nodeArr, int pivot) {
        int less = -1;
        int more = nodeArr.length;
        int index = 0;
        while (index < more) {
            if (nodeArr[index].val < pivot) {
                swap(nodeArr, index++, ++less);
            } else if (nodeArr[index].val > pivot) {
                //将more区域前一个位置的值和index位置的值交换，交换后需要重新比较 index不变
                swap(nodeArr, index, --more);
            } else {
                //相等
                index++;
            }
        }
    }

    private static void swap(ListNode[] nodeArr, int l, int m) {
        ListNode tmp = nodeArr[l];
        nodeArr[l] = nodeArr[m];
        nodeArr[m] = tmp;
    }


    /**
     * 空间复杂度O(1) 方式
     */
    private static ListNode partition(ListNode head, int target) {
        //小于区域head
        ListNode sH = null;
        //小于区域tail
        ListNode sT = null;
        ListNode eH = null;
        ListNode eT = null;
        ListNode bH = null;
        ListNode bT = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = null;
            if (head.val < target) {
                if (sH == null) {
                    //find first less Node assign sH
                    sH = head;
                    sT = head;
                } else {
                    //遍历过程中第二次发现 <target Node 挂在sT后
                    sT.next = head; //为了新增一个Node，而不是将原sT替换成head
                    //当前 head 赋值 sT
                    sT = head;
                }
            } else if (head.val == target) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.next = head;
                    eT = head;
                }
            } else if (head.val > target) {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.next = head;
                    bT = head;
                }
            }
            head = next;
        }
        //小于区域 & 等于区域首尾连接
        if (sH != null) {
            sT.next = eH;
            //考虑等于区域不存在情况
            eT = eT == null ? sT : bH;
        }
        if (eT != null) {
            eT.next = bH;
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }


}
