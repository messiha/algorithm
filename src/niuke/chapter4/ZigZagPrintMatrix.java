/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter4;

/**
 * @author yan.zhang
 * @date 2019/10/19 15:57
 */

/**
 * "之"字打印矩阵
 * 思路：矩阵左上角定义两个点A,B  A每次向右移动(A到达最右向下移动)，B每次向下移动(碰到下边界向右移动)
 * 定义boolean值约束由上打印到下/由下打印到上
 */
public class ZigZagPrintMatrix {

    private static void zigZagPrintMatrix(int[][] matrix) {
        //0 行  0 列
        int aRow = 0;
        int aColumn = 0;
        int bRow = 0;
        int bColumn = 0;
        //定义a,b终点行号和列号
        int endRow = matrix.length - 1;
        int endColumn = matrix[0].length - 1;
        boolean fromUp = false;
        //A点的行号到达endRow 代表A点已经运行到右下角，整个流程结束
        while (aRow != endRow + 1) {
            //确定A,B点行号列号，打印对角线函数
            printLevel(matrix, aRow, aColumn, bRow, bColumn, fromUp);
            //A点运行到最后一列 A点行号++，否则不变
            aRow = aColumn == endColumn ? aRow + 1 : aRow;
            aColumn = aColumn == endColumn ? aColumn : aColumn + 1;
            //bColumn 变化在前 如果bRow在前会影响 bColumn = bRow == endRow ? bColumn + 1 : bColumn;
            bColumn = bRow == endRow ? bColumn + 1 : bColumn;
            bRow = bRow == endRow ? bRow : bRow + 1;
            fromUp = !fromUp;
        }
    }

    private static void printLevel(int[][] matrix, int aRow, int aColumn, int bRow, int bColumn, boolean fromUp) {
        if (fromUp) {
            //由上至下打印
            while (aRow != bRow + 1) {
                System.out.print(matrix[aRow++][aColumn--] + " ");
            }
        } else {
            while (bRow != aRow - 1) {
                System.out.print(matrix[bRow--][bColumn++] + " ");
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        zigZagPrintMatrix(matrix);
    }
}
