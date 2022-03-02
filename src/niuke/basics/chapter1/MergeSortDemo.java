package src.niuke.basics.chapter1;

import java.util.Arrays;

/**
 * @Author yan.zhang
 * @Date 2022/2/7 16:40
 * @Version 1.0
 */
public class MergeSortDemo {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int hi = 0;
        int p1 = l;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= r) {
            help[hi++] = arr[p1] > arr[p2] ? arr[p2++] : arr[p1++];
        }

        while (p1 <= mid) {
            help[hi++] = arr[p1++];
        }

        while (p2 <= r) {
            help[hi++] = arr[p2++];
        }

        //copy
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

    }
}
