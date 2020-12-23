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

        System.out.println();

        preOrder(head);
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
