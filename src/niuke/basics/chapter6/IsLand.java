/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter6;

/**
 * @author yan.zhang
 * @date 2020/1/11 19:36
 */

/**
 * 岛问题：
 * 一个矩阵中只有0,1两种值，每个位置都可以和自己的上下左右四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个矩阵中有多少个岛
 * ag：
 * 001010
 * 111010
 * 100100
 * 000000
 * 这个矩阵中有三个岛
 */
public class IsLand {

    public static void main(String[] args) {
        int[][] isLand = {{0, 0, 1, 0, 1, 0}, {1, 1, 1, 0, 1, 0}, {1, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0}};
        int count = countIsLand(isLand);
        System.out.println(count);
    }

    private static int countIsLand(int[][] isLand) {
        int M = isLand.length;
        int N = isLand[0].length;
        int count = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (isLand[i][j] == 1) {
                    count++;  //岛屿个数+1，将周边数字感染
                    infect(isLand, i, j, M, N);
                }
            }
        }
        return count;
    }

    /**
     * 递归完成感染函数
     */
    private static void infect(int[][] isLand, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || isLand[i][j] != 1) {
            return;
        }
        isLand[i][j] = 2;
        infect(isLand, i + 1, j, m, n);
        infect(isLand, i - 1, j, m, n);
        infect(isLand, i, j + 1, m, n);
        infect(isLand, i, j - 1, m, n);
    }
}
