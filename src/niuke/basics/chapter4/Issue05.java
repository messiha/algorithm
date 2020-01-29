/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/9 22:30
 */

/**
 * 转圈打印矩阵(顺时针打印)
 * <p>
 * 思路：求取左上角坐标和右下角坐标 形成子矩阵 打印四条边
 */
public class Issue05 {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        spiralOrderPrint(arr);
    }


    public static void spiralOrderPrint(int[][] matrix) {
        //定义右上角行号，右上角列号
        int a = 0;
        int b = 0;
        //右下角行号
        int c = matrix.length - 1;
        //右下角列号
        int d = matrix[0].length - 1;
        while (a < c && b < d) {
            printMatrix(matrix, a++, b++, c--, d--);
        }
    }


    private static void printMatrix(int[][] m, int a, int b, int c, int d) {
        //左上角横坐标 == 右上角横坐标 一条直线
        if (a == c) {
            for (int i = b; i <= d; i++) {
                System.out.println(m[a][i] + " ");
            }
        } else if (b == d) {
            //一条竖线
            for (int i = a; i <= d; i++) {
                System.out.println(m[i][b] + " ");
            }
        } else {
            int curA = a;
            int curB = b;
            while (curB != d) {
                System.out.println(m[a][curB] + " ");
                curB++;
            }
            while (curA != c) {
                System.out.println(m[curA][d] + " ");
                curA++;
            }
            while (curB != b) {
                System.out.println(m[c][curB] + " ");
                curB--;
            }
            while (curA != a) {
                System.out.println(m[curA][b] + " ");
                curA--;
            }
        }

    }
}
