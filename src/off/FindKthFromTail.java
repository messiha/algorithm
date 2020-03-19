/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/3/19 11:23
 */

import src.datastruct.SingleListNode;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthFromTail {

    public static void main(String[] args) {
        SingleListNode head = new SingleListNode(1);
        SingleListNode n2 = new SingleListNode(2);
        SingleListNode n3 = new SingleListNode(3);
        SingleListNode n4 = new SingleListNode(4);
        SingleListNode n5 = new SingleListNode(5);
        head.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(n5);
        System.out.println(find(head, 5).val);
    }

    private static SingleListNode find(SingleListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //快指针先走k步
        SingleListNode f = head;
        SingleListNode s = head;

        for (int i = 0; i < k; i++) {
            //边界处理
            if (f == null) {
                return null;
            }
            f = f.next;
        }

        //快慢指针一起走
        while (f != null) {
            f = f.next;
            s = s.next;
        }
        //当快指针走到null位置，慢指针的位置即为倒数第k个node
        return s;

    }


}
