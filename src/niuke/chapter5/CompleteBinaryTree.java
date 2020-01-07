/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter5;

/**
 * @author yan.zhang
 * @date 2019/12/29 17:07
 */

import src.datastruct.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 若设二叉树的深度为h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。
 * 判断一颗树是否为完全二叉树
 * 思路：按层遍历
 * 1)任意节点，有右节点，没有左节点，一定不是完全二叉树
 * 2)任意节点，如果不是左右节点均存在，之后遍历到的节点必须是叶子节点，否则一定不是完全二叉树
 */
public class CompleteBinaryTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        isCBT(head);
    }

    private static boolean isCBT(TreeNode head) {
        if (null == head) {
            return true;
        }
        boolean leaf = false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(head);
        TreeNode R;
        TreeNode L;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            R = curNode.right;
            L = curNode.left;
            //1.leaf = true 左右节点有一个不为null 返回false  ||  左节点为null，右节点不为null 返回false
            if ((leaf && (L != null || R != null)) || L == null && null != R) {
                return false;
            }

            if (L != null) {
                queue.offer(L);
            }
            if (R != null) {
                queue.offer(R);
            } else { //左节点不为null，右节点为null
                leaf = true; //之后所有节点均必须为叶子节点，否则不是完全二叉树
            }

        }
        return true;
    }
}
