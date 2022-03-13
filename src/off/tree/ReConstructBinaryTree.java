/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off.tree;

import src.datastruct.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yan.zhang
 * @date 2020/12/13 19:13
 */
public class ReConstructBinaryTree {
    //重建二叉树,假设输入的前序遍历和中序遍历的结果中都不含重复的数字

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
//        TreeNode head = reConstructBinaryTree(pre, in);
//        TreeNode head = reConstructBinaryTree2(pre, in);
//        TreeNode head = buildTreeHelper(pre, 0, pre.length, in, 0, in.length);

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        TreeNode head = buildTreeHelper_1(pre, 0, pre.length, in, 0, in.length, map);
        preOrder(head);

    }

    private static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || pre.length == 0 || in == null || in.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(pre[0]);

        //find root index
        int headIndex = 0;

        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                headIndex = i;
                break;
            }
        }

        //build
        head.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, headIndex + 1), Arrays.copyOfRange(in, 0, headIndex));
        head.right = reConstructBinaryTree(Arrays.copyOfRange(pre, headIndex + 1, pre.length), Arrays.copyOfRange(in, headIndex + 1, in.length));


        return head;

    }


    private static TreeNode buildTreeHelper(int[] pre, int p_start, int p_end, int[] in, int i_start, int i_end) {
        //中序数组已经搜寻完成，已经为叶结点。
        if (i_start == i_end) {
            return null;
        }

        //前序遍历，根节点值
        int preRootVal = pre[p_start];
        TreeNode root = new TreeNode(preRootVal);

        //中序中遍历确定根节点下标
        int rootIndex = 0;
        for (int i = i_start; i < in.length; i++) {
            if (preRootVal == in[i]) {
                rootIndex = i;
                break;
            }
        }

        int leftNum = rootIndex - i_start;
        //构建左子树
        root.left = buildTreeHelper(pre, p_start + 1, p_start + leftNum + 1, in, i_start, rootIndex);
        //构建右子树
        root.right = buildTreeHelper(pre, p_start + leftNum + 1, p_end, in, rootIndex + 1, i_end);

        return root;
    }


    /**
     * 优化思路：
     * 先遍历一遍inOrder数组，哈希表记录值和下标关系
     *
     * @param pre
     * @param p_start
     * @param p_end
     * @param in
     * @param i_start
     * @param i_end
     * @return
     */
    private static TreeNode buildTreeHelper_1(int[] pre, int p_start, int p_end, int[] in, int i_start, int i_end, Map<Integer, Integer> map) {
        if (i_start == i_end) {
            return null;
        }

        //前序遍历，根节点值
        int preRootVal = pre[p_start];
        TreeNode root = new TreeNode(preRootVal);

        //中序中遍历确定根节点下标
        int rootIndex = map.get(preRootVal);

        int leftNum = rootIndex - i_start;
        //构建左子树
        root.left = buildTreeHelper_1(pre, p_start + 1, p_start + leftNum + 1, in, i_start, rootIndex, map);
        //构建右子树
        root.right = buildTreeHelper_1(pre, p_start + leftNum + 1, p_end, in, rootIndex + 1, i_end, map);
        return root;
    }


    /**
     * 思路:先序遍历得到根节点，然后在中序遍历中找到根节点的位置，它的左边就是左子树的节点，右边就是右子树的节点。
     *
     * @param pre
     * @param in
     * @return
     */
    private static TreeNode reConstructBinaryTree2(int[] pre, int[] in) {

        if (pre.length == 0 || in.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(pre[0]);

        for (int i = 0; i < in.length; i++) {
            if (in[i] == pre[0]) {
                head.left = reConstructBinaryTree2(Arrays.copyOfRange(pre, 1, i + 1), Arrays.copyOfRange(in, 0, i));
                head.right = reConstructBinaryTree2(Arrays.copyOfRange(pre, i + 1, pre.length), Arrays.copyOfRange(in, i + 1, in.length));
                break;
            }
        }

        return head;
    }

    private static void preOrder(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.getValue());
        preOrder(head.left);
        preOrder(head.right);
    }
}
