/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.exercise;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2020/8/10 13:47
 */
public class Practice5 {

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] res = partition(arr, L, R);
            quickSort(arr, L, res[0] - 1);
            quickSort(arr, res[1] + 1, R);
        }

    }

    private static int[] partition(int[] arr, int L, int R) {
        int less = L - 1;
        int more = R;
        int index = L;
        while (index < more) {
            if (arr[index] < arr[R]) {
                swap(arr, ++less, index++);
            } else if (arr[index] > arr[R]) {
                swap(arr, --more, index);
            } else {
                index++;
            }
        }

        swap(arr, R, more);
        return new int[]{less + 1, more};
    }


    //交换i,j
    public static void swap(int[] arr, int i, int j) {
        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
