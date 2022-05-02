package src.leetcode.island;

/**
 * @author yan.zhang
 * @date 2022/5/2 17:37
 */
public class IslandPerimeter {
    /**
     * 岛屿的周长
     * https://leetcode-cn.com/problems/island-perimeter/
     */
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(perimeter(grid));
    }

    private static int perimeter(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    ans += dfs(grid, i, j);
                }
            }
        }
        return ans;
    }

    /**
     * 画图可以推断，岛屿周长为：与网格边界相邻周长+与水域方格相邻的周长
     *
     * @param grid
     * @param i
     * @param j
     */
    private static int dfs(int[][] grid, int i, int j) {
        //触及网格边界
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return 1;
        }
        //从岛屿(1)触及水域(0)
        if (grid[i][j] == 0) {
            return 1;
        }

        //重复
        if (grid[i][j] == 2) {
            return 0;
        }
        grid[i][j] = 2;
        return dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j + 1) +
                dfs(grid, i, j - 1);
    }
}
