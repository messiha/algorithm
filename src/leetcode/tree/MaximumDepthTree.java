package src.leetcode.tree;

import java.util.List;

/**
 * @author yan.zhang
 * @date 2022/2/26 11:06
 */
public class MaximumDepthTree {
    /**
     * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
     * N叉树最大深度
     */
    public static void main(String[] args) {
        Node node = new Node();
        maxDepth(node);
    }

    /**
     * 深度优先遍历
     *
     * @param node
     * @return
     */
    private static int maxDepth(Node node) {
        if (node == null) {
            return 0;
        }
        int depth = 0;

        for (int i = 0; i < node.children.size(); i++) {
            depth = Math.max(maxDepth(node.children.get(i)), depth);
        }

        //假设N叉树只有一层,这里返回1
        return depth + 1;
    }


    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;

}
