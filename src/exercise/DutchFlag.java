/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.exercise;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2020/1/30 20:07
 */
public class DutchFlag {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
        solution(arr, 5);
        System.out.println(Arrays.toString(arr));
    }

    private static void solution(int[] arr, int target) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < target) {
                swap(arr, i, ++index);
            }
        }
    }


    private static void swap(int[] arr, int j, int i) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
