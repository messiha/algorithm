package src.leetcode.tree;

import src.datastruct.TreeNode;

/**
 * @Author yan.zhang
 * @Date 2022/5/24 11:21
 * @Version 1.0
 */

public class MinimumDepthOfBinaryTree {
    /**
     * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
     * 二叉树最小深度
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     */
    public static void main(String[] args) {

    }

    public int minDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        //该节点不是叶节点 不参与递归计算过程
        if (root.left != null && root.right == null) {
            return 1 + minDepth(root.left);
        }
        if (root.right != null && root.left == null) {
            return 1 + minDepth(root.right);
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return Math.min(left, right) + 1;
    }
}
