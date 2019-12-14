/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.leetcode;

/**
 * @author yan.zhang
 * @date 2019/5/26 11:08
 */
public class ArrayMaxValue {

    /**
     * 使用递归思想求一个数组中最大值
     */
    private static int getMax(int[] arr, int R, int L) {
        //设置中止条件 当范围不能继续拆分 中止
        while (L == R) {
            return arr[L];
        }
        int mid = (R + L) / 2;
        int maxLeft = getMax(arr, L, mid);
        int maxRight = getMax(arr, mid + 1, R);
        return Math.max(maxLeft, maxRight);
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        System.out.println(getMax(arr, 0, arr.length - 1));
    }
}
