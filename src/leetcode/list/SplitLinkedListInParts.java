package src.leetcode.list;

import src.datastruct.ListNode;

/**
 * @author yan.zhang
 * @date 2022/4/17 22:37
 */
public class SplitLinkedListInParts {
    /**
     * 分隔链表
     * https://leetcode-cn.com/problems/split-linked-list-in-parts/
     */
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(2);
        ListNode h3 = new ListNode(3);
        ListNode h4 = new ListNode(4);
        ListNode h5 = new ListNode(5);
        head.next = h2;
        h2.next = h3;
        h3.next = h4;
        h4.next = h5;

        ListNode[] listNodes = splitList(head, 2);
    }

    private static ListNode[] splitList(ListNode head, int k) {
        int cnt = 0;
        ListNode p = head;
        while (p != null) {
            cnt++;
            p = p.next;
        }
        int part = cnt / k, remainder = cnt % k;

        ListNode[] ans = new ListNode[k];
        ListNode curr = head;
        for (int i = 0; i < k && curr != null; i++) {
            ans[i] = curr;
            int partSize = part + (i < remainder ? 1 : 0);
            for (int j = 1; j < partSize; j++) {
                curr = curr.next;
            }
            ListNode next = curr.next;
            curr.next = null;
            curr = next;
        }

        return ans;
    }
}
