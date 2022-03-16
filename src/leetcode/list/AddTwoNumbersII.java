package src.leetcode.list;

import src.datastruct.ListNode;

import java.util.Stack;

/**
 * @Author yan.zhang
 * @Date 2022/3/15 15:58
 * @Version 1.0
 */
public class AddTwoNumbersII {
    /**
     * https://leetcode-cn.com/problems/add-two-numbers-ii/
     * 两数相加
     */
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        addTwoNumbers(l1, l2);
    }


    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        //入栈
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        //计算
        int carry = 0;
        ListNode ans = null;

        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int a = s1.isEmpty() ? 0 :s1.pop();
            int b = s2.isEmpty() ? 0 :s2.pop();

            int sum = a + b + carry;
            carry = sum / 10;

            ListNode curNode = new ListNode(sum % 10);
            curNode.next = ans;
            ans = curNode;
        }


        return ans;
    }
}
