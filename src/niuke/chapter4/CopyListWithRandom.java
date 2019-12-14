/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/27 16:50
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 复制含有随机指针节点的链表
 * 链表结构为Node，rand指针是Node类中新增的指针，这个指针可能指向链表中的任意一个节点，也可能指向null，给定一个由Node节点
 * 类型组成的无环单项链表的头节点head，实现一个函数完成这个链表中所有结构的复制，并复制新链表的头节点。
 * <p>
 * 进阶：不使用额外的数据结构，只使用有限的几个变量，并且时间复杂度为O(N)内完成原问题要实现的函数
 */
public class CopyListWithRandom {


    /**
     * 思路一:
     * 使用HashMap辅助，建立Node1和Node1'映射关系
     */
    public static Node copyListWithRand1(Node head) {
        if (null == head || head.next == null) {
            return head;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node NodeCp = map.get(cur);
            NodeCp.next = map.get(cur.next);
            NodeCp.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }


    /**
     * 思路二:
     * 将拷贝节点放在当前节点的下一个  ag: 1->1`->2->2`->3->3`->null
     */
    public static Node copyListWithRand2(Node head) {
        if (null == head || head.next == null) {
            return head;
        }
        Node cur = head;
        while (cur != null) {
            Node next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        //设置random指针
        cur = head;
        while (cur != null) {
            Node next = cur.next.next;
            Node nodeCp = cur.next;
            nodeCp.random = cur.random != null ? cur.random.next : null;
            cur = next;
        }
        //分离
        cur = head;
        Node res = head.next;
        while (cur != null) {
            Node next = cur.next.next;
            Node nodeCp = cur.next;
            cur.next = next;
            nodeCp.next = next != null ? next.next : null;
            cur = next;
        }
        return res;
    }


    /**
     * 含有随机指针链表结构
     */
    private static class Node {
        public int val;
        public Node next;
        public Node random;

        private Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }


    public static void main(String[] args) {
        Node head = null;
        Node res1 = null;
        Node res2 = null;
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = new Node(6);

        head.random = head.next.next.next.next.next; // 1 -> 6
        head.next.random = head.next.next.next.next.next; // 2 -> 6
        head.next.next.random = head.next.next.next.next; // 3 -> 5
        head.next.next.next.random = head.next.next; // 4 -> 3
        head.next.next.next.next.random = null; // 5 -> null
        head.next.next.next.next.next.random = head.next.next.next; // 6 -> 4

        printRandLinkedList(head);
        res1 = copyListWithRand1(head);
        printRandLinkedList(res1);
        res2 = copyListWithRand2(head);
        printRandLinkedList(res2);
        printRandLinkedList(head);
        System.out.println("=========================");
    }

    private static void printRandLinkedList(Node head) {
        Node cur = head;
        System.out.print("order: ");
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
        cur = head;
        System.out.print("rand:  ");
        while (cur != null) {
            System.out.print(cur.random == null ? "- " : cur.random.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
