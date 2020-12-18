package src.off.tree;

import src.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yan.zhang
 * @date 2020/12/18 11:52
 */
public class PrintByLevel {
    /**
     * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(5, new TreeNode(4), new TreeNode(6));
        Print(head);
    }


    /**
     * 按层遍历模板方法
     * 1.头结点入队
     * 2.记录当前队列大小size
     *
     * @param pRoot
     * @return
     */
    private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(pRoot);

        while (!queue.isEmpty()) {
            ArrayList<Integer> split = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                split.add(node.getValue());

                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
                size--;
            }
            result.add(split);
        }

        return result;
    }

}
