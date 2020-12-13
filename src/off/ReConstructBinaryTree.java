/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

import src.datastruct.TreeNode;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2020/12/13 19:13
 */
public class ReConstructBinaryTree {
    //重建二叉树,假设输入的前序遍历和中序遍历的结果中都不含重复的数字

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode head = reConstructBinaryTree(pre, in);
        preOrder(head);
    }

    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(pre[0]);

        //find root index
        int headIndex = 0;

        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                headIndex = i;
                break;
            }
        }

        //build
        head.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, headIndex + 1), Arrays.copyOfRange(in, 0, headIndex));
        head.right = reConstructBinaryTree(Arrays.copyOfRange(pre, headIndex + 1, pre.length), Arrays.copyOfRange(in, headIndex + 1, in.length));


        return head;

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
