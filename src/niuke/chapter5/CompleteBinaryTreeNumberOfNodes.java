/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter5;

/**
 * @author yan.zhang
 * @date 2019/12/29 21:55
 */

import src.datastruct.TreeNode;

/**
 * 已知一颗完全二叉树，求其节点个数
 * 要求：时间复杂度低于O(N),N为这颗树节点数
 * <p>
 * 思路：
 * 如果一颗树的高度为L,并且是一颗满二叉树，则节点个数2^L-1
 * 1.遍历左子树，求树最大高度 O(logN)
 * 2.遍历右子树，求树右侧最大高度
 * 3.如果右子树最大高度和左子树最大高度一致，则头节点的左子树是满二叉树
 */

//O(logN^2)
public class CompleteBinaryTreeNumberOfNodes {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        int number = binaryTreeNumber(head);
        System.out.println(number);
    }

    private static int binaryTreeNumber(TreeNode head) {
        if (null == head) {
            return 0;
        }

        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * @param node  当前节点
     * @param level 当前Node节点在l层
     * @param h     树深度
     * @return 以node为head的子树节点个数
     */
    private static int bs(TreeNode node, int level, int h) {
        if (level == h) { //当前节点在最后一层，即叶节点
            return 1;
        }

        //mostLeftLevel(node.right, level + 1) 求node右子树左边界在第几层
        if (mostLeftLevel(node.right, level + 1) == h) { //右子树深度等于左子树深度，则左子树是满二叉树
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else { //右子树深度不等于左子树深度,右子树是满二叉树
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }

    }

    private static int mostLeftLevel(TreeNode node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

}
