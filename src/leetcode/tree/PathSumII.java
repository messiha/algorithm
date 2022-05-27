package src.leetcode.tree;

import src.datastruct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author yan.zhang
 * @Date 2022/5/27 16:48
 * @Version 1.0
 */
public class PathSumII {
    /**
     * https://leetcode.cn/problems/path-sum-ii/
     * 路径总和
     */
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        TreeNode root = new TreeNode(5,new TreeNode(4,new TreeNode(11,new TreeNode(7),new TreeNode(2)),null),new TreeNode(8,new TreeNode(13),new TreeNode(4, new TreeNode(5), new TreeNode(1))));
        pathSum(root, 22);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(root, targetSum, path, ans);
        return ans;
    }

    private static void dfs(TreeNode root, int targetSum, Deque<Integer> path, List<List<Integer>> ans) {
        if (null == root) {
            return;
        }
        path.offerLast(root.value);
        targetSum -= root.value;
        if (root.left == null && root.right == null && targetSum == 0) {
            ans.add(new ArrayList<>(path));
            //这里不能return，否则会丢失一次poll操作
        }
        dfs(root.left, targetSum, path, ans);
        dfs(root.right, targetSum, path, ans);
        path.pollLast();
    }
}
