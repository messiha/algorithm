package src.exercise;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2020/11/26 下午4:21
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {5, 4, 9, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        process(arr, 0, arr.length - 1);
    }

    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        process(arr, 0, mid);
        process(arr, mid + 1, r);
        merge(arr, l, r, mid);
    }

    private static void merge(int[] arr, int l, int r, int mid) {
        int[] help = new int[r - l + 1];
        int hi = 0;
        int p1 = l;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= r) {
            help[hi++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= mid) {
            help[hi++] = arr[p1++];
        }

        while (p2 <= r) {
            help[hi++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }


    //交换i,j
    public static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
