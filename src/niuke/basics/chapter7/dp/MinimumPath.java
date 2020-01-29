/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter7.dp;

/**
 * @author yan.zhang
 * @date 2020/1/28 11:51
 */

/**
 * 二维数组中，从左上角走到右下角，每次只能走一步，求最短路径和
 */
public class MinimumPath {
    public static void main(String[] args) {
        int[][] matrix = {{3, 2, 1, 0}, {7, 5, 0, 1}, {3, 7, 6, 2}};
        System.out.println(process(matrix, 0, 0));
    }

    /**
     * 暴力枚举
     * (row,col)位置出发，到达右下角位置，最短路径
     *
     * @param matrix
     * @param row    行坐标
     * @param col    列坐标
     */
    private static int process(int[][] matrix, int row, int col) {
        //已经在右下角,返回右下角值
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            return matrix[row][col];
        }
        //在最后一行,只能右移，问题可以抽象成，路径和为:当前位置值  + 下一个位置到最右路径最小和
        if (row == matrix.length - 1) {
            return matrix[row][col] + process(matrix, row, col + 1);
        }
        if (col == matrix[0].length - 1) {
            return matrix[row][col] + process(matrix, row + 1, col);
        }
        int right = process(matrix, row, col + 1);//右侧位置到右下角最短路径和
        int left = process(matrix, row + 1, col);//左侧位置到右下角最短路径和
        return matrix[row][col] + Math.min(right, left);//当前位置值+ ...
    }

    /**
     * 修改为动态规划
     * 前提：
     * 1.类似于上述问题，在路径中会重复枚举状态
     * 2.重复状态(先右后下||先下后右)与到达右下角最短路径没有联系
     *  换句话说，当前的决策会影响后续的决策
     *
     * ag:汉诺塔问题，不能动态规划，打印移动步骤，重复状态与最终结果有关联
     */
}
