package src.off;


import src.datastruct.ListNode;

/**
 * 输入两个链表，找出他们的第一个公共节点
 */
public class FindFirstCommonNode {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(1);

        ListNode point = findFirstCommonNode(head1, head2);
    }

    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (null == pHead1 || null == pHead2) {
            return null;
        }
        ListNode h1 = pHead1;
        ListNode h2 = pHead2;

        int n = 0;
        while (h1.next != null) {
            n++;
            h1 = h1.next;
        }
        while (h2.next != null) {
            n--;
            h2 = h2.next;
        }

        //最后的节点不相等，说明两个链表不相交
        if (h1 != h2) {
            return null;
        }

        //h1指向长链表
        h1 = n > 0 ? pHead1 : pHead2;
        h2 = h1 == pHead1 ? pHead2 : pHead1;
        n = Math.abs(n);

        while (n != 0) {
            h1 = h1.next;
            n--;
        }

        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }
        return h1;
    }
}
