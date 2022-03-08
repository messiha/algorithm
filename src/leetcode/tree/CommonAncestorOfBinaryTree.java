package src.leetcode.tree;

import src.datastruct.TreeNode;

/**
 * @Author yan.zhang
 * @Date 2022/3/7 17:17
 * @Version 1.0
 */
public class CommonAncestorOfBinaryTree {
    /**
     * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
     * 二叉树的最近公共祖先
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode p = new TreeNode(0);
        TreeNode q = new TreeNode(0);
//        lowestCommonAncestor(root, p, q);
        lowestCommonAncestor_02(root, p, q);
    }

    /**
     * p 和 qq 在 root 的子树中，且分列 root 的 异侧（即分别在左、右子树中）；
     * p = root ，且 q 在 root 的左或右子树中；
     * q = root ，且 p 在 root的左或右子树中；
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    private static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) return null;
        if (null == left) return right;
        if (null == right) return left;

        return root;
    }


    /**
     * 两种情况结束
     * 1.当前为root节点，root左子树和右子树均包含p，q。当左子树为p，右子树只能为q
     * 2.当root节点为p或q时，且root的左子树或右子树包含p或q
     * 备注：因为题目每个节点值一定不同。
     */
    private static TreeNode ans = null;

    private static boolean lowestCommonAncestor_02(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = lowestCommonAncestor_02(root.left, p, q);
        boolean right = lowestCommonAncestor_02(root.right, p, q);

        if ((left && right) || ((root == p || root == q) && (left || right))) {
            ans = root;
        }

        //从树底层向上返回,若底层叶节点存在(root == p || root == q),向上返回时则一直为true。
        //代表p或q在以当前root为根节点的子树上
        return left || right || (root == p || root == q);
    }


}
