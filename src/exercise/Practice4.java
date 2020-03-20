package src.exercise;

import src.datastruct.ListNode;

import java.util.ArrayList;
import java.util.Arrays;

public class Practice4 {

    private static ArrayList<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.setNext(n2);
        ArrayList<Integer> integers = printByInsertHead(n1);
        System.out.println(Arrays.toString(integers.toArray()));
    }

    public static ArrayList<Integer> printByInsertHead(ListNode node) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ListNode head = node;
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

    public static ArrayList<Integer> printByRecur(ListNode listNode) {
        if (listNode != null) {
            ArrayList<Integer> list = printByRecur(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
