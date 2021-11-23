package src.xmly;

import src.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author yan.zhang
 * @Date 2021/11/23 19:04
 * @Version 1.0
 */
public class LayerTravelTree {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        //按层打印二叉树
        List<ArrayList<Integer>> travel = LayerTravelTree.travel(head);
        System.out.println(travel);
    }

    private static List<ArrayList<Integer>> travel(TreeNode head) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (head == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            ArrayList<Integer> stash = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                stash.add(node.value);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            result.add(stash);
        }
        return result;
    }
}
