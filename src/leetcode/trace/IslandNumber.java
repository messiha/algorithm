package src.leetcode.trace;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yan.zhang
 * @date 2022/4/20 15:57
 */
public class IslandNumber {
    /**
     * 岛屿数量
     * https://leetcode-cn.com/problems/number-of-islands/
     */
    public static void main(String[] args) {
        char[][] grid = new char[10][10];
        System.out.println(numsIslands(grid));
    }

    private static int numsIslands(char[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


    /**
     * 广度优先思路
     */
    private static void bfs(char[][] grid, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            i = cur[0];
            j = cur[1];
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
              continue;
            }
            grid[i][j] = '0';
            queue.offer(new int[]{i + 1, j});
            queue.offer(new int[]{i - 1, j});
            queue.offer(new int[]{i, j + 1});
            queue.offer(new int[]{i, j - 1});
        }
    }
}
