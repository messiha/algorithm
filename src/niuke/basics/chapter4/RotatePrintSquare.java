/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/10 23:13
 */

import java.util.Arrays;

/**
 * 顺时针旋转90度打印正方形矩阵
 */
public class RotatePrintSquare {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        rotateSquare(arr);
    }

    private static void rotateSquare(int[][] arr) {
        int a = 0;
        int b = 0;
        int c = arr.length - 1;
        int d = arr[0].length - 1;
        while (a < c) {
            rotateEdge(arr, a++, b++, c--, d--);
        }
        Arrays.stream(arr).forEach(e -> System.out.println(Arrays.toString(e)));
    }

    private static void rotateEdge(int[][] arr, int a, int b, int c, int d) {
        //旋转次数
        int times = d - b;
        //tmp 临时变量
        int tmp;
        //找出对应四个点分别交换位置
        for (int i = 0; i != times; i++) {
            tmp = arr[a][b + i];

            arr[a][b + i] = arr[c - i][b];

            arr[c - i][b] = arr[c][d - i];

            arr[c][d - i] = arr[a + i][d];

            arr[a + i][d] = tmp;
        }

    }
}
