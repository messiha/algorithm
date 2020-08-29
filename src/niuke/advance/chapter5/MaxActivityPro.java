package src.niuke.advance.chapter5;

/**
 * @author yan.zhang
 * @date 2020/8/29 15:37
 */

/**
 * 一个公司的关系是一颗多叉树，该公司举办晚会，到场规则如下：
 * 一个员工的直接上级如果到场，这个员工肯定不来，每个员工都有一个活跃度的值，决定谁来会给这个员工发邀请函，如何能让晚会活跃度最大，返回最大的活跃值
 * <p>
 * 举例：给定一个矩阵表述这种关系
 * matrix =
 * [
 * 1,6
 * 1,5
 * 1,4
 * ]
 * <p>
 * 该矩阵含义：
 * matrix[0] = [1,6],代表0号员工的直接上级是1，0号员工的活跃度为6
 * matrix[1] = [1,5],代表1号员工的直接上级是1(该员工上级是自身，1号员工为公司boss)...
 * matrix[2] = [1,4],代表2号员工的直接上级是1，2号员工的活跃度是4
 * 为使晚会活跃度最大，邀请函应发给，0，2，1号员工不来，则最大活跃度为10
 */
public class MaxActivityPro {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 6}, {1, 5}, {1, 4}};
        System.out.println(getMaxHappiness(matrix));
    }

    private static int getMaxHappiness(int[][] matrix) {
        int[][] dp = new int[matrix.length][2];

        boolean[] visited = new boolean[matrix.length];

        //代表头，即公司boss
        int root = 0;

        //寻找root
        for (int i = 0; i < matrix.length; i++) {
            if (i == matrix[i][0]) {
                root = i;
            }
        }

        process(matrix, dp, root, visited);

        return Math.max(dp[root][0], dp[root][1]);
    }

    /**
     * @param matrix
     * @param dp      dp[i][0]:坐标i不来活跃度 ,dp[i][1]: 坐标i来活跃度
     * @param root
     * @param visited
     */
    private static void process(int[][] matrix, int[][] dp, int root, boolean[] visited) {
        //假设boss来，除boss外所有员工都不来
        visited[root] = true;

        dp[root][1] = matrix[root][1];

        for (int i = 0; i < matrix.length; i++) {

            //依次遍历所有员工，当 当前员工的上级为boss时，并且当前员工不来，并且boss不来情况
            if (matrix[i][0] == root && !visited[i]) {

                //当前员工 "来" 的情况
                process(matrix, dp, i, visited);

                dp[root][1] += dp[i][0];
                //boss不来情况
                dp[root][0] += Math.max(dp[i][1], dp[i][0]);
            }
        }
    }
}

