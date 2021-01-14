package src.off.tree;

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2020/12/23 15:06
 */
public class Practice {
    /**
     * 二叉树的镜像
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(8, new TreeNode(6, new TreeNode(5, null, null), new TreeNode(7, null, null)), new TreeNode(10, new TreeNode(9, null, null), new TreeNode(11, null, null)));
        preOrder(head);

        System.out.println("=======");

        mirror(head);

        preOrder(head);
    }

    private static TreeNode mirror(TreeNode head) {
        if (null == head) {
            return head;
        }
        mirror(head.left);
        mirror(head.right);
        swap(head, head.left, head.right);
        return head;
    }

    private static void swap(TreeNode head, TreeNode left, TreeNode right) {
        head.left = right;
        head.right = left;
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
