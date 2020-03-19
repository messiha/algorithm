/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

import src.datastruct.SingleListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * @author yan.zhang
 * @date 2019/8/10 22:20
 */

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class PrintListFromTailToHead {

    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        SingleListNode n1 = new SingleListNode(1);
        SingleListNode n2 = new SingleListNode(2);
        n1.setNext(n2);
        ArrayList<Integer> integers = printListFromTailToHead(n1);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public static ArrayList<Integer> printByListReverse(SingleListNode node) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        SingleListNode head = node;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
//        Collections.reverse(list);
        //翻转函数
        reverse(list);
        return list;
    }

    private static void reverse(ArrayList<Integer> list) {
        int i = 0, j = list.size() - 1;
        while (i < j) {
            swap(i, j, list);
            i++;
            j--;
        }
    }

    private static void swap(int i, int j, ArrayList<Integer> list) {
        int tmp = 0;
        tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static ArrayList<Integer> printListFromTailToHead(SingleListNode singleListNode) {
        //思路2 栈
        Stack<Integer> stack = new Stack<>();
        while (singleListNode != null) {
            stack.push(singleListNode.val);
            singleListNode = singleListNode.next;

        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (!stack.empty()) {
            list.add(stack.pop());
        }
        return list;


    }

    public static ArrayList<Integer> printByRecur(SingleListNode singleListNode) {
        if (singleListNode != null) {
            ArrayList<Integer> list = printByRecur(singleListNode.next);
            list.add(singleListNode.val);
        }
        return list;
    }

    public static ArrayList<Integer> printByInsertHead(SingleListNode node) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        SingleListNode head = node;
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.reverse(list);
        return list;
    }


}



