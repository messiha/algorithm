package src.exercise;

import src.datastruct.TreeNode;

import java.util.Stack;

public class Practice3 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
//        inOrderOnRecur(head);
        postOrderOnRecur(head);
//        preOrderOnRecur(head);
    }

    private static void inOrderOnRecur(TreeNode head) {
        if (null == head) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                head = stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                System.out.println(head.getValue());
                head = head.right;
            }
        }
    }

    private static void postOrderOnRecur(TreeNode head) {
        if (null == head) {
            return;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.add(head);
            if (head.left != null) {
                s1.add(head.left);
            }
            if (head.right != null) {
                s1.add(head.right);
            }
        }
        while (!s2.isEmpty()) {
            TreeNode node = s2.pop();
            System.out.println(node.getValue());
        }

    }

    private static void preOrderOnRecur(TreeNode head) {
        if (null == head) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.println(head.getValue());
            if (head.right != null) {
                stack.add(head.right);
            }
            if (head.left != null) {
                stack.add(head.left);
            }
        }
    }
}
