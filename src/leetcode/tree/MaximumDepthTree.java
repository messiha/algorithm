package src.leetcode.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
        dfs(node);
    }

    /**
     * 深度优先遍历
     *
     * @param node
     * @return
     */
    private static int dfs(Node node) {
        if (node == null) {
            return 0;
        }
        int depth = 0;

        for (int i = 0; i < node.children.size(); i++) {
            depth = Math.max(dfs(node.children.get(i)), depth);
        }

        //假设N叉树只有一层,这里返回1
        return depth + 1;
    }

    /**
     * 广度优先
     *
     * @param node
     * @return
     */
    private static int bfs(Node node) {
        if (node == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node cur = queue.poll();
                List<Node> children = cur.children;
                for (Node child : children) {
                    queue.offer(child);
                }
                size--;
            }
            depth++;
        }
        return depth;
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
