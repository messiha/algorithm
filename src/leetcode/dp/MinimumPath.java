package src.leetcode.dp;

/**
 * @Author yan.zhang
 * @Date 2022/3/4 16:58
 * @Version 1.0
 */
public class MinimumPath {
    /**
     * https://leetcode-cn.com/problems/minimum-path-sum/
     * 最小路径和
     */
    public static void main(String[] args) {
//        int[][] arr = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] arr = new int[][]{{1, 2, 3}, {4, 5, 6}};
        System.out.println(minPathSum(arr));
    }

    private static int minPathSum(int[][] grid) {
        int[][] help = new int[grid.length][grid[0].length];
        help[0][0] = grid[0][0];

        //init 第一行
        for (int i = 1; i < grid[0].length; i++) {
            help[0][i] = help[0][i - 1] + grid[0][i];
        }

        //init 第一列
        for (int i = 1; i < grid.length; i++) {
            help[i][0] = help[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < help.length; i++) {
            for (int j = 1; j < help[0].length; j++) {
                help[i][j] = grid[i][j] + Math.min(help[i - 1][j], help[i][j - 1]);
            }
        }

        return help[help.length - 1][help[0].length - 1];
    }

    //在grid上做填表修改
    private static int minPathSum_02(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) continue;
                else if (i == 0) grid[i][j] = grid[i][j - 1] + grid[i][j];
                else if (j == 0) grid[i][j] = grid[i - 1][j] + grid[i][j];
                else grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


}
