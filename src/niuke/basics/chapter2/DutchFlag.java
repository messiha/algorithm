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
 * 数组的荷兰国旗问题
 * 给定一个数组arr 和一个数num，将小于等于num的数放在数组左边，大于num的数放在数组右边
 * 要求额外空间复杂度O(1),时间复杂度O(N)
 * 复杂度O(1) 不使用额外的数据结构
 */
public class DutchFlag {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
        solution1(arr, 5);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 思路：遍历数组，若小于target 和 小于等于区域的下一个数交换位置，小于等于区域扩大
     */
    private static void solution1(int[] arr, int target) {
        //x表示 x左侧均满足小于等于num
        int x = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= target) {
                swap(arr, i, ++x);
            }
        }
    }


    /**
     * 扩展:荷兰国旗问题
     * 给定一个数组arr 和一个数num，将小于等于num的数放在数组左边，大于num的数放在数组右边，等于放中间
     */
    private static void solution2(int[] arr, int target) {
        int less = -1;
        //more 在数组最后一位 后一个位置  arr.length
        int more = arr.length;
        int cur = 0;
        //停止条件:cur 向右移动  more向左移动  当cur = more 循环停止
        while (cur < more) {
            if (arr[cur] < target) {
                //小于 交换后cur+1
                swap(arr, cur++, ++less);
            } else if (arr[cur] > target) {
                //大于
                swap(arr, cur, --more);
            } else {
                //相等 cur++
                cur++;
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
