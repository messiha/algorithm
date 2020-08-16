package src.niuke.advance.chapter5;


/**
 * 给定一颗二叉树头结点head，返回最大搜索二叉子树的大小
 */

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2020/8/10 23:00
 */

public class BiggestSearchBinaryTree {
    /**
     * 思路：三种可能性
     * 1.最大搜索二叉树在左子树
     * 2.最大搜索二叉树在右子树
     * 3.前提：以头结点，左子树为搜索二叉树，右子树为搜索二叉树。头结点左子树最大值比头结点小，右子树最小值比头结点大，则最大搜索二叉子树为以头结点的树。
     * <p>
     * 递归过程
     * 以上三种情况所需信息：
     * 1）以头结点开始的左子树最大搜索二叉子树大小
     * 2）以头结点开始的右子树最大搜索二叉子树大小
     * 3）最大搜索二叉树左子树头结点（检查最大左子树头结点是否为head的左子结点）
     * 4）最大搜索二叉树右子树头结点
     * 4）左子树最大值
     * 5）右子树最小值
     * <p>
     * 设计递归
     * 1.递归返回对象（递归针对每个字结点都做同样操作，对任意结点左部分递归或右部分递归得到结构应该一致）
     */
    public static void main(String[] args) {

    }

    private ReturnData process(TreeNode head) {
        if (head == null) {
            return new ReturnData(0, null, 0, 0);
        }
        TreeNode left = head.left;
        TreeNode right = head.right;

        //左过程
        ReturnData leftData = process(left);
        ReturnData rightData = process(right);

        //可能性3
        int includeSelf = 0;

        if (leftData.head == left && leftData.max < head.getValue() && rightData.head == right && rightData.min > head.getValue()) {
            includeSelf = leftData.size + rightData.size + 1;
        }

        //可能性1，head节点左子树大小
        int p1 = leftData.size;
        int p2 = rightData.size;

//        Math.max();
        return new ReturnData(0, null, 0, 0);

    }


    private static class ReturnData {
        /**
         * 左/右搜索二叉树大小
         */
        private int size;
        /**
         * 左/右最大搜索二叉树头结点
         */
        private TreeNode head;

        private int max;
        private int min;

        public ReturnData(int size, TreeNode head, int max, int min) {
            this.size = size;
            this.head = head;
            this.max = max;
            this.min = min;
        }
    }
}
