/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/3/18 16:17
 */

import java.util.Arrays;

/**
 * 输入一个整数数组,实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
 * 并且保证奇数和奇数之间，偶数和偶数之间的相对位置保持不变
 * ag: 1,2,4,3,5  >  1,3,5,2,4  调整后1仍然在5前
 */
public class AdjustArrOrder {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        modify(arr);
        System.out.println(Arrays.toString(arr));
    }

    //相邻交换可以保证稳定性
    private static void modify(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] % 2 == 0 && arr[j + 1] % 2 == 1) {
                    swap(j, j + 1, arr);
                }
            }
        }
    }

    private static void swap(int p1, int p2, int[] arr) {
        int tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }
}
