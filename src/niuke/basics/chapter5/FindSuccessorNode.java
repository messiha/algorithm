/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter5;


/**
 * 在二叉树中找到一个节点的后继节点
 * 现有一种新的二叉树节点类型如下：
 * 该结构比普通二叉树节点结构多了一个指向父节点的Parent指针，假设有一颗Node类型的节点组成的二叉树，树中每个节点的parent指针都
 * 正确的指向自己的父节点，头节点的parent指向null。只给一个在二叉树中的某个节点node，请实现返回node的后继节点的函数，在二叉树
 * 的中序遍历的序列中，node的下一个节点叫做node的后继节点。
 */
public class FindSuccessorNode {
    /**
     * 思路：1.对于某个Node，如果有右节点，则后继节点一定是右子树的最左节点
     * 2.对于某个Node，如果没有右节点，后继节点一定是：哪个节点的左子树的最后一个节点是当前节点
     */
    public static void main(String[] args) {
        Node head = new Node(6);
        head.parent = null;
        head.left = new Node(3);
        head.left.parent = head;
        head.left.left = new Node(1);
        head.left.left.parent = head.left;
        head.left.left.right = new Node(2);
        head.left.left.right.parent = head.left.left;
        head.left.right = new Node(4);
        head.left.right.parent = head.left;
        head.left.right.right = new Node(5);
        head.left.right.right.parent = head.left.right;
        head.right = new Node(9);
        head.right.parent = head;
        head.right.left = new Node(8);
        head.right.left.parent = head.right;
        head.right.left.left = new Node(7);
        head.right.left.left.parent = head.right.left;
        head.right.right = new Node(10);
        head.right.right.parent = head.right;

        Node test = head.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.left.right.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.left;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right;
        System.out.println(test.value + " next: " + getSuccessorNode(test).value);
        test = head.right.right; // 10's next is null
        System.out.println(test.value + " next: " + getSuccessorNode(test));
//        Node successorNode = getSuccessorNode(head);

    }

    private static Node getSuccessorNode(Node node) {
        //判断是否有右节点
        if (node == null) {
            return node;
        }
        if (node.right != null) {
            return getLeftTreeMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    /*private static Node getLeftTreeMost(Node node) {
        if (node.left == null) {
            return node;
        }
        return getLeftTreeMost(node.left);
    }*/

    private static Node getLeftTreeMost(Node node) {
        if (node == null) {
            return node;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static class Node {
        private int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

}
