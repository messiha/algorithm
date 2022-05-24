package src.leetcode.tree;

import src.datastruct.TreeNode;

/**
 * @Author yan.zhang
 * @Date 2022/5/24 14:54
 * @Version 1.0
 */
public class PathSum {
    /**
     * 路径总和
     * https://leetcode.cn/problems/path-sum/
     */
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        //叶节点
        if (root.left == null && root.right == null) {
            return targetSum - root.value == 0;
        }

        return hasPathSum(root.left, targetSum - root.value) ||
                hasPathSum(root.right, targetSum - root.value);

    }
}
