package src.off.tree;


import src.datastruct.TreeNode;

/**
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 思路一：按层遍历
 * 思路二：递归
 */
public class TreeDepth {
    public static void main(String[] args) {
        TreeNode head = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)), new TreeNode(3, new TreeNode(6, null, null), new TreeNode(7, null, null)));
        Node node = calTreeDepth(head);
        System.out.println(TreeDepth(head));
        System.out.println(node.h);
        System.out.println(node.route);
    }

    private static Node calTreeDepth(TreeNode root) {
        if (root == null) {
            return new Node(0, 0);
        }

        Node leftNode = calTreeDepth(root.left);
        Node rightNode = calTreeDepth(root.right);

        int maxH = (leftNode.route - rightNode.route) >= 0 ? leftNode.h : rightNode.h;

        return new Node(maxH + 1, Math.max(leftNode.route, rightNode.route) + 1);
    }

    private static class Node {
        //当前深度
        private int h;
        //长度
        private int route;

        public Node(int h, int route) {
            this.h = h;
            this.route = route;
        }
    }


    public static int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        return 1 + (Math.max(leftDepth, rightDepth));
    }
}
