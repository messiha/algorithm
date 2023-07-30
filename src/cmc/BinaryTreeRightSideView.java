package src.cmc;

import src.datastruct.TreeNode;

import java.util.*;

/**
 * @author yan.zhang
 * @date 2023/7/30 13:24
 */
public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2,null,new TreeNode(5)),new TreeNode(3,null,new TreeNode(4)));
        List<Integer> ans = rightSideView(root);
        System.out.println(ans);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Map<Integer, TreeNode> rightmostValueAtDepth = new HashMap<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();
        int depth = 0;
        nodeQueue.offer(root);
        depthQueue.offer(0);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            depth = depthQueue.poll();
            if (null != node) {
                rightmostValueAtDepth.put(depth, node);
                nodeQueue.offer(node.left);
                nodeQueue.offer(node.right);
                depthQueue.offer(depth + 1);
                depthQueue.offer(depth + 1);
            }
        }
        for (int i = 0; i < depth; i++) {
            ans.add(rightmostValueAtDepth.get(i).getValue());
        }
        return ans;
    }
}
