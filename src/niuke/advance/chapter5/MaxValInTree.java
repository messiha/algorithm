package src.niuke.advance.chapter5;


/**
 * 求整颗树上最大值和最小值
 * 思路：求这个树上以任意一个节点为头结点的树的最大值和最小值
 */

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2020/8/16 23:29
 */
public class MaxValInTree {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        printMinAndMaxVal(head);
        process(head);
    }

    private static void printMinAndMaxVal(TreeNode head) {
        ReturnData returnData = process(head);
        System.out.println("max: " + returnData.max + " " + "min: " + returnData.min);
    }

    private static ReturnData process(TreeNode head) {
        if (head == null) {
            //返回值问题，考虑子结点向上一层结点返回的数据，不能最上一层结点的"决策"造成干扰。及为null的节点返回的最大值为系统最小，最小值为系统最大
            return new ReturnData(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);

        return new ReturnData(
                Math.max(Math.max(leftData.max, rightData.max), head.value),
                Math.min(Math.min(leftData.min, rightData.min), head.value));

    }


    static class ReturnData {
        private int max;
        private int min;

        public ReturnData(int max, int min) {
            this.max = max;
            this.min = min;
        }
    }
}
