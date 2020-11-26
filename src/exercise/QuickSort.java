/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.exercise;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2020/3/23 9:42
 */
class QuickSort {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, r, l + (int) (Math.random() * (r - l + 1)));
            int[] p = partition(arr, l, r);
            process(arr, l, p[0] - 1);
            process(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;

        while (l < more) {
            if (arr[l] < arr[r]) {
                swap(arr, l++, ++less);
            } else if (arr[l] > arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }

        swap(arr, r, more);
        return new int[]{less + 1, more};
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
