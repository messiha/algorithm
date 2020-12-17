package src.off.tree;

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2020/12/17 16:13
 */
public class ConvertToList {
    /**
     * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
     */
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        TreeNode head = new TreeNode(5, new TreeNode(4), new TreeNode(6));
        TreeNode node = Convert(head);
        System.out.println(node.getValue());

    }

    private static TreeNode pLast = null;

    private static TreeNode Convert(TreeNode pRootOfTree) {
        //中序遍历
        if (pRootOfTree == null) {
            return null;
        }

        TreeNode head = Convert(pRootOfTree.left);
        if (head == null) {
            head = pRootOfTree;
        }

        //连接
        pRootOfTree.left = pLast;

        if (pLast != null) {
            pLast.right = pRootOfTree;
        }

        pLast = pRootOfTree;

        Convert(pRootOfTree.right);

        return head;
    }

}
