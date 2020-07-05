package src.niuke.advance.chapter3;

/**
 * @author yan
 * @date 2020/7/417:37
 */

import src.datastruct.TreeNode;

/**
 * 定义二叉树节点如下  src.datastruct.TreeNode
 * ...
 * 一个数组的maxTree定义如下。数组必须没有重复元素，maxTree是一颗二叉树，数组中每一个值对应一个二叉树节点。
 * 包括maxTree树在内且在其中每一棵子树上，值最大的节点都是树的头。
 * 有重复元素的数组arr，写出生成这个数组maxTree的函数，要求数组长度为N，时间复杂度为O（N）,空间复杂度O(N)
 */
public class MaxTree {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 0, 5};
        buildMaxTreeByHeap(arr);
    }

    /**
     * 思路1：
     * 建立大根堆后，将大根堆还原成树
     */
    private static void buildMaxTreeByHeap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        //构建树
        TreeNode treeNode = buildTree(arr, 0, arr.length);
        //序列化
        System.out.println();
    }

    /**
     * 根据数组构建树
     *
     * @param arr
     * @param index
     * @param length
     * @return
     */
    private static TreeNode buildTree(int[] arr, int index, int length) {
        if (index >= length) {
            return null;
        }
        TreeNode head = new TreeNode(arr[index]);
        head.left = buildTree(arr, 2 * index + 1, length);
        head.right = buildTree(arr, 2 * index + 2, length);
        return head;
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[(index - 1) / 2] < arr[index]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * 思路2：
     * 单调栈解法：
     * arr数组中每一个值都能获取到，左侧比该值大，右侧比该值大的树
     * 1)如果数组中某个值，左右都无最大值，即全局最大值，头结点
     * 2)如果数组中某个值，只有左侧最大值或只有右侧最大值，则该结点只有唯一的父结点,直接挂在这个节点下
     * 3)如果数组中某个值，既有左侧最大值又有右侧最大值，则该值挂在 两个最大值中较小的那个节点下
     */


}
