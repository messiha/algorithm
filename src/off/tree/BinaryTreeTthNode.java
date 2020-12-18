package src.off.tree;

import src.datastruct.TreeNode;

import java.util.Stack;

/**
 * @author yan.zhang
 * @date 2020/12/17 17:17
 */
public class BinaryTreeTthNode {
    /**
     * 给定一棵二叉搜索树，请找出其中的第k小的结点。
     * 输入:{5,3,7,2,4,6,8},3
     * 输出:4
     */
    public static void main(String[] args) {
        TreeNode pRoot = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
//        System.out.println(KthNode(pRoot, 1));
        System.out.println(KthNodeByRecur(pRoot, 5).getValue());
    }

    private static int index = 0;

    private static TreeNode KthNodeByRecur(TreeNode pRoot, int k) {

        if (pRoot == null || k < 1) {
            return null;
        }
        return getKth(pRoot, k);
    }

    private static TreeNode getKth(TreeNode pRoot, int k) {
        TreeNode node = null;

        if (pRoot.left != null) {
            node = getKth(pRoot.left, k);
        }

        //pRoot子节点为null
        index++;

        if (index == k) {
            node = pRoot;
        }

        if (node == null && pRoot.right != null) {
            node = getKth(pRoot.right, k);
        }

        return node;
    }


    private static TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || pRoot != null) {

            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                k--;
                if (k == 0) {
                    break;
                }
                pRoot = pRoot.right;
            }
        }

        return pRoot;

    }
}
