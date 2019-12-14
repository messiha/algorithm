/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/24 23:05
 */

/**
 * 在行列都排好序的矩阵中找数
 * 给定一个N*M的整形矩阵matrix和一个整数k，matrix的每一行和每一列都是排好序的，实现一个函数
 * 判断K是否在matrix中，ag:{{0,1,2,5},{2,3,4,7},{4,4,4,8},{5,7,7,9}}
 * 如果K为7返回true，K为6返回false
 * 要求时间复杂度为O(N+M),额外空间复杂度O(1)
 */
public class SearchSortedMatrix {
    public static void main(String[] args) {
        int[][] arr = {{0, 1, 2, 5}, {2, 3, 4, 7}, {4, 4, 4, 8}, {5, 7, 7, 9}};
        int endRow = arr.length - 1;
        int endColumn = arr[0].length - 1;
        int target = 6;
        boolean result = searchSortedMatrix(endRow, endColumn, arr, target);
        System.out.println(result);
    }

    private static boolean searchSortedMatrix(int row, int endColumn, int[][] arr, int target) {
        int i = 0;
        for (; i < endColumn && row >= 0; ) {
            if (arr[row][i] > target) {
                row--;
            } else if (arr[row][i] < target) {
                i++;
            } else if (arr[row][i] == target) {
                return true;
            }
        }
        return false;
    }
}
