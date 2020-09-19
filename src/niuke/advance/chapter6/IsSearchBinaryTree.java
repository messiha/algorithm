/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter6;

/**
 * @author yan.zhang
 * @date 2020/9/14 22:23
 */

import src.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 判断一棵树是否为搜索二叉树
 */
public class IsSearchBinaryTree {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        System.out.println(isBST(head));
        System.out.println(isCBT(head));
    }

    /**
     * 判断一棵树是否为完全二叉树
     * CompleteBinaryTree
     *
     * @param head
     * @return
     */
    private static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode left;
        TreeNode right;
        boolean leaf = false;

        queue.add(head);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            left = cur.left;
            right = cur.right;

            if (leaf && (left != null || right != null) || right != null && left == null) {
                return false;
            }


            if (left != null) {
                queue.offer(left);
            }

            if (right != null) {
                queue.offer(right);
            }

            if (left != null && right == null) {
                leaf = true;
            }
        }

        return true;

    }

    private static boolean isBST(TreeNode head) {
        if (null != head) {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            while (!stack.isEmpty() || head != null) {
                if (head != null) {
                    stack.push(head);
                    head = head.left;
                } else {
                    head = stack.pop();
                    if (pre != null && pre.value >= head.value) {
                        return false;
                    }
                    pre = head;
                    head = head.right;
                }
            }
        }
        return true;

    }


}
