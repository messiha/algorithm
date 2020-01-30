package src.exercise;

import src.datastruct.TreeNode;

public class Practice2 {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));


        System.out.println(isBalanceTree(head));
    }

    private static boolean isBalanceTree(TreeNode head) {
        return process(head).bal;
    }

    private static Result process(TreeNode head) {
        if (null == head) {
            return new Result(0, true);
        }
        Result leftRes = process(head.left);
        if (!leftRes.bal) {
            return new Result(0, false);
        }
        Result rightRes = process(head.right);
        if (!rightRes.bal) {
            return new Result(0, false);
        }
        if (Math.abs(leftRes.h - rightRes.h) > 1) {
            return new Result(0, false);
        }

        return new Result(Math.max(leftRes.h, rightRes.h) + 1, true);
    }


    private static class Result {
        private int h;
        private boolean bal;

        public Result(int h, boolean bal) {
            this.h = h;
            this.bal = bal;
        }
    }
}
