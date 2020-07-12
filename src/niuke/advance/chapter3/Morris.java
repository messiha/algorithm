package src.niuke.advance.chapter3;

/**
 * @author yan
 * @date 2020/7/1116:21
 */

import src.datastruct.TreeNode;

/**
 * 二叉树传统遍历
 * 时间复杂度O(N) 额外空间复杂度O(h) h为树高
 * <p>
 * 二叉树-莫里斯遍历：
 * 时间复杂度O(N) 额外空间复杂度O(1)
 * <p>
 * <p>
 * 1.来到的当前节点记为cur，如果cur无左孩子，cur向右移动
 * 2.如果cur有左孩子,找到cur左子树上最右的节点，记为mostright
 * -1）如果mostright右指针指向null，让其指向cur，cur向左移动
 * -2）如果mostright右指针指向cur，让其指向空，cur向右移动
 */
public class Morris {

    /**
     * 实质：
     * 如果Node有左子树 会回到cur两次，如果没有左子树，只会来到cur一次
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
//        morrisIn(head);
        morrisPre(head);
    }

    /**
     * morris 中序
     *
     * @param head
     */
    private static void morrisIn(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;

        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                //find mostRight node
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            }
            System.out.println(cur.getValue());
            cur = cur.right;
        }
    }


    /**
     * morris 先序遍历
     *
     * @param head
     */
    private static void morrisPre(TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode cur = head;
        TreeNode mostRight = null;

        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    //如果cur有左子树，会经过cur两次，第一次经过cur打印
                    System.out.println(cur.getValue());
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                //如果当前cur节点没有左子树，打印
                System.out.println(cur.getValue());
            }
            cur = cur.right;
        }
    }
}
