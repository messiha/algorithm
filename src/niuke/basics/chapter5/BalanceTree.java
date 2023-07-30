/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter5;

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
//      TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(3, null, null), null), null);
        boolean isBal = isBalanceTree(head);
        System.out.println(isBal);
    }

    private static boolean isBalanceTree(TreeNode head) {
        return process(head).isBal;
    }

    private static Result process(TreeNode node) {
        if (node == null) {
            return new Result(true, 0); //空树是平衡树
        }
        Result leftRes = process(node.left);
        //如果左树不平衡，直接返回
        if (!leftRes.isBal) {
            //isBal为false，h可以为0,只有左isBal，右isBal均为true，才会比较h的值
            return new Result(false, 0);
        }
        Result rightRes = process(node.right);
        //如果右树不平衡
        if (!rightRes.isBal) {
            return new Result(false, 0);
        }
        //如果左树平衡，右树平衡
        if (Math.abs(leftRes.h - rightRes.h) > 1) {
            return new Result(false, 0);
        }
        //左树平衡，右树平衡，返回树的高度为，左子树高度和右子树高度最大差值加1
        return new Result(true, Math.max(leftRes.h, rightRes.h) + 1);
    }

    static class Result {
        //是否平衡
        private boolean isBal;
        //高度
        private int h;

        public Result(boolean isBal, int h) {
            this.isBal = isBal;
            this.h = h;
        }
    }


    //解法2
    public boolean isBalanced(TreeNode root) {
        return height(root) >= 0;
    }

    private int height(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        } else {
            return Math.max(left, right) + 1;
        }


    }


}
