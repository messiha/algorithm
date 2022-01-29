/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter5;

import src.datastruct.TreeNode;

import java.util.Stack;

/**
 * @author Lenovo
 * @date 2019/12/15 11:37
 */
public class PreInPosTraversal {
    public static void main(String[] args) {
        /**
         *       1
         *      / \
         *     2   3
         *   / \  / \
         *  4  5 6  7
         *
         */
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        preOrderRecur(head);
//       preOrderUnRecur(head);
//       inOrderUnRecur(head);
//       aftOrderUnRecur(head);
//       inOrderUnRecur(head);
    }


    /**
     * 先序遍历 递归
     * 每个节点实际会出现三次
     */
    public static void preOrderRecur(TreeNode head) {
        if (null == head) {
            return;
        }
        System.out.println(head.getValue());//先序遍历
        preOrderRecur(head.left);
//        System.out.println(head.getValue());//中序遍历
        preOrderRecur(head.right);
//        System.out.println(head.getValue());//后序遍历
    }


    /**
     * 非递归版 先序遍历
     */
    public static void preOrderUnRecur(TreeNode head) {
        System.out.println("pre-order: ");
        if (null != head) {
            Stack<TreeNode> stack = new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.println(head.getValue());
                if (null != head.right) {
                    stack.push(head.right);
                }
                if (null != head.left) {
                    stack.push(head.left);
                }
            }
        }
    }

    /**
     * 非递归版 中序遍历
     * 思路：将当前节点左部分全部入栈
     * 1.当前节点为空，栈中弹出，打印，head指针右移
     * 2.当前节点不为空，当前节点压入栈，head指针指向下一个左node
     */
    public static void inOrderUnRecur(TreeNode head) {
        System.out.println("in-order: ");
        if (null != head) {
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || null != head) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    System.out.println(head.getValue());
                    head = head.right;
                }
            }
        }
    }


    /**
     * 思路:1.将树中节点按 中，右，左顺序入栈
     * 2.使用辅助栈将其逆序弹出并打印
     */
    public static void aftOrderUnRecur(TreeNode head) {
        if (null != head) {
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(head);
            while (!s1.isEmpty()) {
                head = s1.pop();
                s2.push(head);
                if (null != head.left) {
                    s1.push(head.left);
                }
                if (null != head.right) {
                    s1.push(head.right);
                }
            }
            while (!s2.isEmpty()) {
                System.out.println(s2.pop().getValue());
            }
        }
    }

}
