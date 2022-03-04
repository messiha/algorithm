package src.leetcode.tree;

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2022/3/4 21:51
 */
public class MergeTwoBinaryTree {
    /**
     * https://leetcode-cn.com/problems/merge-two-binary-trees/
     * 合并二叉树
     */
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        mergeTrees(t1, t2);
    }

    private static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        //一个为null，或两个都不为null
        TreeNode root = new TreeNode((root1 == null ? 0 : root1.value) + (root2 == null ? 0 : root2.value));

        root.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return root;
    }
}
