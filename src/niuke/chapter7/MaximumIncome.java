/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter7;

/**
 * @author yan.zhang
 * @date 2020/1/26 16:00
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 计算最大收益：
 * cost[]代表花费数组,profit[]代表收益数组，cost[0]对应profit[0]
 * 启动资金W,最多可完成K个项目,单每次只能做一个项目，资金不够或达到K停止，计算最大收益
 * <p>
 * 思路：花费构建小根堆，收益构建大根堆
 */
public class MaximumIncome {

    private static int findMaximizedCapital(int k, int w, int[] profit, int[] cost) {
        Node[] nodes = new Node[profit.length];
        //生成node
        for (int i = 0; i < profit.length; i++) {
            nodes[i] = new Node(cost[i], profit[i]);
        }

        PriorityQueue<Node> minCostQ = new PriorityQueue<>(new MinCostComparator()); //小根堆
        PriorityQueue<Node> maxProfitQ = new PriorityQueue<>(new MaxProfitComparator());

        //加入小根堆
        for (int i = 0; i < nodes.length; i++) {
            minCostQ.add(nodes[i]);
        }

        for (int i = 0; i < k; i++) {
            while (!minCostQ.isEmpty() && minCostQ.peek().c <= w) {
                maxProfitQ.add(minCostQ.poll());
            }
            //minCostQ.peek().c <= w 不成立
            if (maxProfitQ.isEmpty()) {
                return w;
            }
            w += maxProfitQ.poll().p;
        }
        return w;
    }

    private static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.c - o2.c;//负数 o1.c < o2.c  升序
        }
    }

    private static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.p - o1.p;//降序
        }
    }

    private static class Node {
        private int c;//花费
        private int p;//收益

        public Node(int c, int p) {
            this.c = c;
            this.p = p;
        }
    }

    public static void main(String[] args) {
        int[] c = {};
        int[] p = {};
    }
}
