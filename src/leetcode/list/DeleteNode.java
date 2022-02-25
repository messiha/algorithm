package src.leetcode.list;

/**
 * @author yan.zhang
 * @date 2019/9/7 23:17
 */

import src.datastruct.ListNode;

/**
 * 删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 * 输入: head = [4,5,1,9], node = 1
 * 输出: [4,5,9]
 */
public class DeleteNode {
    public static void main(String[] args) {

    }

    /**
     * 复制下一节点的值到当前node，改变引用
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
