package src.leetcode.dp;

import java.util.Arrays;

/**
 * @Author yan.zhang
 * @Date 2022/3/4 16:21
 * @Version 1.0
 */
public class UniquePath {
    /**
     * https://leetcode-cn.com/problems/unique-paths/
     * 不同路径
     */
    public static void main(String[] args) {
        System.out.println(uniquePathsOptimize(3, 7));
    }

    private static int uniquePaths(int m, int n) {
        int[][] help = new int[m][n];
        //init
        for (int i = 0; i < m; i++) {
            help[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            help[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                help[i][j] = help[i - 1][j] + help[i][j - 1];
            }
        }

        return help[m - 1][n - 1];
    }


    //空间复杂度优化
    private static int uniquePathsOptimize(int m, int n) {
        int[] help = new int[n];
        Arrays.fill(help, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                help[j] = help[j] + help[j - 1];
            }
        }

        return help[n-1];
    }
}
