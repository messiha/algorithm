package src.leetcode.list;

import src.datastruct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author yan.zhang
 * @Date 2022/3/14 10:20
 * @Version 1.0
 */
public class RemoveDuplicateNode {
    /**
     * https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
     * 移除重复节点
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        removeDuplicateNodes(head);
    }


    private static ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> visited = new HashSet<>();
        ListNode pre = null, cur = head;
        while (cur != null) {
            if (visited.contains(cur.val)) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                visited.add(cur.val);
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
