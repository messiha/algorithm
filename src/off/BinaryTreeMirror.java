package src.off;

import src.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yan.zhang
 * @date 2020/12/15 11:00
 */
public class BinaryTreeMirror {
    /**
     * 二叉树的镜像
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(8, new TreeNode(6, new TreeNode(5, null, null), new TreeNode(7, null, null)), new TreeNode(10, new TreeNode(9, null, null), new TreeNode(11, null, null)));
        mirror(head);

        preOrder(head);
    }

    private static void mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                //swap
                swap(cur, cur.left, cur.right);

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }

    }

    private static void swap(TreeNode cur, TreeNode left, TreeNode right) {
        cur.left = right;
        cur.right = left;
    }


    private static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.getValue());
        preOrder(head.left);
        preOrder(head.right);
    }

}
