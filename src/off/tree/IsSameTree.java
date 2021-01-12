/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off.tree;

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2021/1/12 23:02
 */

public class IsSameTree {
    /**
     * 给定两个二叉树，编写一个函数验证两颗树是否相等
     * 如果两颗树结构上相同，并且节点具有相同的值，则认为相同。
     */
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        TreeNode q = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
        isSameTree(p, q);
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        //一个为null 一个不为null
        if (p == null || q == null) {
            return false;
        }

        return false;
    }

}
