/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter5;

/**
 * @author yan.zhang
 * @date 2019/12/25 22:27
 */

import src.datastruct.TreeNode;

/**
 * 平衡二叉树
 * 这棵树任何一个节点，左子树和右子树高度差不超过1
 * <p>
 * 思路：1.以每个节点作为头节点的树都是平衡树，则整棵树是平衡树
 * -左树是否平衡
 * -右树是否平衡
 * -左树高度
 * -右树高度
 * 2.设计递归栈
 */
public class BalanceTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        isBalanceTree(head);
    }

    private static void isBalanceTree(TreeNode head) {

    }

    static class Result {
        private boolean isBal;
        private int h;
    }


}
