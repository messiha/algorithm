package src.leetcode.tree;

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2022/2/27 11:16
 */
public class MaximumDepthBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        solution(root);
    }

    private static int solution(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = Math.max(solution(root.left),
                solution(root.right));

        return depth + 1;
    }
}
