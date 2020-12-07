package src.exercise;

import src.datastruct.TreeNode;

/**
 * @author yan.zhang
 * @date 2020/8/29 17:25
 */
public class BalanceTree {


    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        System.out.println(isBalance(head));
    }

    private static boolean isBalance(TreeNode head) {
        return process(head).isBalance;
    }

    private static Result process(TreeNode head) {
        if (null == head) {
            return new Result(true, 0);
        }

        Result left = process(head.left);
        if (!left.isBalance) {
            return new Result(false, 0);
        }
        Result right = process(head.right);
        if (!right.isBalance) {
            return new Result(false, 0);
        }

        if (Math.abs(left.h - right.h) > 1) {
            return new Result(false, 0);
        }

        return new Result(true, Math.max(left.h, right.h) + 1);
    }


    private static class Result {
        private boolean isBalance;
        private int h;


        public Result(boolean isBalance, int h) {
            this.isBalance = isBalance;
            this.h = h;
        }
    }
}
