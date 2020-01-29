/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter2;

/**
 * @author yan.zhang
 * @date 2019/6/25 21:40
 */

import java.util.Arrays;

/**
 * 给定一个数组arr 和一个数num，将小于等于num的数放在数组左边，大于num的数放在数组右边
 * 要求额外空间复杂度O(1),时间复杂度O(N)
 * 复杂度O(1) 不使用额外的数据结构
 */
public class Issue01 {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
        solution(arr, 5);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 思路：遍历数组，若小于target 和 小于等于区域的下一个数交换位置，小于等于区域扩大
     */
    private static void solution(int[] arr, int target) {
        //x表示 x左侧均满足小于等于num
        int x = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < target) {
                swap(arr, i, ++x);
            }
        }
    }

    /**
     * 交换位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
