package src.niuke.advance.chapter5;


/**
 * 二叉树中，一个节点可以向上走和向下走，那么从节点A总能走到节点B
 * 节点A到节点B的距离为：A走到B最短路径上的节点个数
 * 求一颗二叉树的最远距离
 */

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2020/8/19 23:19
 */
public class MaxDistance {
    /**
     * 以X为头结点的二叉树的最远距离可能性
     * 1.最大距离可能来自X左子树的最大距离，并且不经过X节点
     * 2......X右子树的最大距离
     * 3.经过X节点...
     * 以上为可能性，支持以上可能性需要已知信息
     * 以X为头结点的树
     * 1）最大距离
     * 2）深度
     */
    public static void main(String[] args) {
        TreeNode head = new TreeNode(0, new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)), new TreeNode(5, null, null));
        System.out.println(getMaxDistance(head));
    }

    private static int getMaxDistance(TreeNode head) {
        return process(head).maxDistance;
    }

    private static ReturnData process(TreeNode head) {
        if (null == head) {
            return new ReturnData(0, 0);
        }

        ReturnData leftData = process(head.left);
        ReturnData rightData = process(head.right);
        //可能性3 = 左子树高度+右子树高度+1
        int includeSelfMaxDistance = leftData.h + 1 + rightData.h;
        //可能性1
        int p1 = leftData.maxDistance;
        //可能性2
        int p2 = rightData.maxDistance;

        int resultDistance = Math.max(Math.max(p1, p2), includeSelfMaxDistance);

        //"决策"返回上层信息
        //Math.max(leftData.h, rightData.h) + 1  ->当前节点返回"上层"高度信息为，当前节点左子树高度和右子树高度最大值 + 1
        return new ReturnData(resultDistance, Math.max(leftData.h, rightData.h) + 1);

    }


    private static class ReturnData {
        private int maxDistance;
        private int h;

        public ReturnData(int maxDistance, int h) {
            this.maxDistance = maxDistance;
            this.h = h;
        }
    }
}
