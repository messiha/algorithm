/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter5;

/**
 * @author yan.zhang
 * @date 2019/12/29 16:49
 */

import src.datastruct.TreeNode;

import java.util.Stack;

/**
 * 搜索二叉树：对于这颗树上的任何一个节点为头的子树，左子树都比该头小，右子树都比该头大
 * 通常情况下，搜索二叉树不含有重复节点，可以将重复的节点压缩成一个List
 * 判断一颗树是否为搜索二叉树
 * 1.思路：中序遍历，节点依次升序，就是搜索二叉树
 */
public class SearchBinaryTree {
    public static void main(String[] args) {
//        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        TreeNode head = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6));
        System.out.println(isSearchBinaryTree(head));
    }

    private static boolean isSearchBinaryTree(TreeNode head) {
        if (null == head) return true;
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (null != head) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
//                System.out.println(head.getValue());
                if (pre != null && head.getValue() <= pre.getValue()) {  //第一次pop() pre == null 不会进入该逻辑
                    return false;
                }
                pre = head;
                head = head.right;
            }
        }
        return true;
    }
}
