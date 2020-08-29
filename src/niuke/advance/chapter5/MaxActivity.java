package src.niuke.advance.chapter5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yan.zhang
 * @date 2020/8/25 23:24
 */
public class MaxActivity {

    /**
     * 1.分析可能性
     * 2.列举解决问题需要的信息全集，设计返回结构。
     * 3.递归，默认每颗子树都返回resultData（黑盒），拆黑盒，组出信息返回上一级
     * 4.baseCase。
     */


    public static void main(String[] args) {
        Node n1 = new Node(6);
        Node n2 = new Node(4);
        ArrayList<Node> sub = new ArrayList<>();
        sub.add(n1);
        sub.add(n2);
        Node head = new Node(5);
        head.next = sub;

        System.out.println(getMaxActivity(head));
    }
    /**
     * 多叉树，求最大活跃度数据结构简化版
     */


    /**
     * 分析可能性：
     * 假设头结点为X，X1,X2,X3为X节点的子结点
     * <p>
     * 可能性1：
     * 1.X参加
     * 则最大活跃度为：X的活跃度+X1不来整棵树的最大活跃度+X2不来整棵树的最大活跃度+X3不来整棵树的最大活跃度
     * 可能性2：
     * 2.X不参加
     * 则最大活跃度为：X1可以参加(X1参加整棵树的最大活跃度)/X1不参加(同理)...  对于X1节点为头的子树，求X1参加或X1不参加两种情况的最大活跃度
     * <p>
     * 分析信息收集：
     * 1.参加~最大活跃度
     * 2.不参加~最大活跃度
     * <p>
     * 设计递归函数
     */


    private static int getMaxActivity(Node node) {
        ResultData resultData = process(node);
        return Math.max(resultData.attend, resultData.noAttend);
    }

    private static ResultData process(Node node) {
        int attend = node.val;
        int noAttend = 0;

        List<Node> next = node.next;

        /**
         * 不需要该baseCase
         * 等同于
         *  int attend = node.val;
         *  int noAttend = 0;
         *   return new ResultData(attend, noAttend);
         */
       /* if (next.size() == 0) {
            return new ResultData(node.val, 0);
        }*/

        //遍历子结点，i < next.size() 已经考虑到递归边界停止条件
        for (int i = 0; i < next.size(); i++) {
            Node sub = next.get(i);

            //递归，每个字结点，参加/不参加最大活跃度
            ResultData subData = process(sub);

            //参加,每一个子结点不来活跃度相加
            attend += subData.noAttend;
            //不参加
            noAttend += Math.max(subData.attend, subData.noAttend);

        }

        return new ResultData(attend, noAttend);

    }


    private static class ResultData {
        private int attend;
        private int noAttend;

        public ResultData(int attend, int noAttend) {
            this.attend = attend;
            this.noAttend = noAttend;
        }
    }


    /**
     * 设计数据结构
     */
    private static class Node {
        /**
         * 活跃度
         */
        private int val;

        private List<Node> next;

        public Node(int val) {
            this.val = val;
            this.next = new ArrayList<>();
        }
    }
}
