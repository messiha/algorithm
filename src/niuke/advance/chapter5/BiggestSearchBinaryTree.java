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
        TreeNode head1 = new TreeNode(0, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)), new TreeNode(5, null, null));
        TreeNode head2 = new TreeNode(4, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)), new TreeNode(5, null, null));
        ReturnData data = process(head1);
        System.out.println(data);
        System.out.println(data.head.getValue());
    }

    private static ReturnData process(TreeNode head) {
        if (head == null) {
            //Integer.MIN_VALUE, Integer.MAX_VALUE 不干扰上层节点"决策"
            return new ReturnData(0, null, Integer.MIN_VALUE, Integer.MAX_VALUE);
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
        //可能性2
        int p2 = rightData.size;

        int maxSize = Math.max(Math.max(p1, p2), includeSelf);

        //可能性1 + 可能性2，最大头结点是该结点 左子搜索二叉树/右子搜索二叉树的头
        TreeNode maxHead = p1 > p2 ? leftData.head : rightData.head;

        //可能性3
        if (maxSize == includeSelf) {
            //以当前节点为头结点的树，是最大搜索二叉树，向"上一级"返回
            maxHead = head;
        }

        return new ReturnData(maxSize, maxHead,
                Math.max(Math.max(leftData.max, rightData.max), head.value),
                Math.min(Math.min(leftData.min, rightData.min), head.value));
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
        /**
         * 左/右树最大值（注意：左树或右树上的最大值）
         */
        private int max;
        private int min;

        public ReturnData(int size, TreeNode head, int max, int min) {
            this.size = size;
            this.head = head;
            this.max = max;
            this.min = min;
        }

        @Override
        public String toString() {
            return "ReturnData{" +
                    "size=" + size +
                    ", head=" + head +
                    ", max=" + max +
                    ", min=" + min +
                    '}';
        }
    }
}
