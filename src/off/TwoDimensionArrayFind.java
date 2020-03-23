/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2019/8/10 16:43
 */

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序
 * 给定一个数，判断是否在二维数组中
 */
public class TwoDimensionArrayFind {
    public static void main(String[] args) {
        int[][] array = {{1, 2}, {3, 4}, {5, 6}};
        System.out.println(find(2, array));
    }

    private static boolean find(int target, int[][] array) {
        int rowCount = array.length;
        int colCount = array[0].length;
        int i, j;
        //从左下角开始 array[rowCount - 1][0]
        for (i = rowCount - 1, j = 0; i >= 0 && j < colCount; ) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target) {
                //小于：右移
                j++;
                continue;
            } else if (array[i][j] > target) {
                i--;
                continue;
            }
        }
        return false;
    }
}
