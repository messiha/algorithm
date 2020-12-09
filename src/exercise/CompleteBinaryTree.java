package src.exercise;

import src.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yan.zhang
 * @date 2020/12/8 18:07
 */
public class CompleteBinaryTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        System.out.println(isCBT(head));
    }

    private static boolean isCBT(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(head);
        boolean leaf = false;
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();

            if ((leaf && (cur.left != null || cur.right != null)) || (cur.right != null && cur.left == null)) {
                return false;
            }

            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            } else {
                leaf = true;
            }

        }
        return true;
    }
}
