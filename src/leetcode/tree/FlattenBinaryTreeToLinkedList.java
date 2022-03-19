package src.leetcode.tree;

import src.datastruct.TreeNode;

import java.util.Stack;

/**
 * @author yan.zhang
 * @date 2022/3/19 18:58
 */
public class FlattenBinaryTreeToLinkedList {
    /**
     * 二叉树展开为链表
     * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten_02(root);
        System.out.println(root);
    }


    /**
     * @param root
     */
    private static void flatten_03(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left != null) {
                TreeNode next = curr.left;
                TreeNode predecessor = next;
                while (predecessor.right != null) {
                    predecessor = predecessor.right;
                }
                predecessor.right = curr.right;
                curr.right = next;
                curr.left = null;
            }
            curr = curr.right;
        }
    }

    /**
     * 递归：后续遍历变形
     * 遍历顺序是右子树->左子树->根节点。
     *
     * @param root
     */
    private static TreeNode pre;

    private static void flatten_02(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten_02(root.right);
        flatten_02(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }

    /**
     * 先序遍历过程中改变引用
     *
     * @param root
     */
    private static void flatten_01(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (null != pre) {
                pre.right = cur;
                pre.left = null;
            }

            if (null != cur.right) {
                stack.push(cur.right);
            }
            if (null != cur.left) {
                stack.push(cur.left);
            }
            pre = cur;
        }
    }

}
