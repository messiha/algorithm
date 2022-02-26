package src.leetcode.tree;

import src.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yan.zhang
 * @Date 2022/2/26 15:55
 * @Version 1.0
 */
public class BinaryTreePaths {
    /**
     * https://leetcode-cn.com/problems/binary-tree-paths/
     * 二叉树所有路径
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        List<String> res = new ArrayList<>();
        solution(root, "", res);
        System.out.println(res);
    }

    private static void solution(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        StringBuilder sb = new StringBuilder(path);
        sb.append(root.value.toString());
        //叶节点
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        } else {
            sb.append("->");
            solution(root.left, sb.toString(), res);
            solution(root.right, sb.toString(), res);
        }

    }
}
