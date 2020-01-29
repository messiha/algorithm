/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter5;

/**
 * @author yan.zhang
 * @date 2019/12/22 22:25
 */

/**
 * 类比后继节点题目，返回前驱节点，中序遍历，一个节点的前一个节点叫做前驱节点
 */
public class FindPrecursorsNode {
    /**
     * 思路：1.如果有左子树，前驱节点一定是左子树上的最右节点
     * 2.如果没有左子树，前驱节点: 向上搜索，当前节点是父节点的右节点停止
     */
    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.parent = head;
        head.right = new Node(3);
        head.right.parent = head;

        head.left.left = new Node(4);
        head.left.left.parent = head.left;
        head.left.right = new Node(5);
        head.left.right.parent = head.left;
        head.right.left = new Node(6);
        head.right.left.parent = head.right;
        head.right.right = new Node(7);
        head.right.right.parent = head.right;

        System.out.println(getPrecursorsNode(head.right.left).getValue());
    }


    private static Node getPrecursorsNode(Node node) {
        if (null == node) {
            return node;
        }
        if (node.left != null) {
            return getLeftTreeMost(node.left);
        } else {
            Node parNode = node.parent;
            while (parNode != null && parNode.right != node) {
                node = parNode;
                parNode = parNode.parent;
            }
            return parNode;
        }
    }

    private static Node getLeftTreeMost(Node leftNode) {
        if (null == leftNode.right) {
            return leftNode;
        }
        return getLeftTreeMost(leftNode.right);
    }


    private static class Node {
        private int value;
        public FindPrecursorsNode.Node left;
        public FindPrecursorsNode.Node right;
        public FindPrecursorsNode.Node parent;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
