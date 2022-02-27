package src.leetcode.tree;

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2022/2/27 13:57
 */
public class IsBalanceTree {
    /**
     * https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof/
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), null), null);
        System.out.println(solution01(root).isBalance);
        System.out.println(solution02(root) != -1);
    }

    /**
     * 后续遍历，从底至顶返回子树深度，如果不是平衡树，直接返回
     *
     * @param root
     * @return
     */
    private static int solution02(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = solution02(root.left);
        if (left == -1)
            return -1;

        int right = solution02(root.right);
        if (right == -1)
            return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


    private static PathData solution01(TreeNode root) {
        if (null == root) {
            return new PathData(0, true);
        }
        PathData left = solution01(root.left);
        PathData right = solution01(root.right);

        if (!left.isBalance || !right.isBalance) {
            return new PathData(0, false);
        }
        if (Math.abs(left.depth - right.depth) > 1) {
            return new PathData(0, false);
        }

        return new PathData(Math.max(left.depth, right.depth) + 1, true);

    }

    static class PathData {
        private int depth;
        private boolean isBalance;

        public PathData(int depth, boolean isBalance) {
            this.depth = depth;
            this.isBalance = isBalance;
        }
    }
}
