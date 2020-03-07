package src.exercise;

import java.util.Arrays;

public class Practice4 {

    public static void main(String[] args) {
//        int[] arr = {5, 4, 3, 2, 1};
        int[] arr = {1, 3, 4, 2, 5};
        System.out.println(mergeSort(arr));
        System.out.println(Arrays.toString(arr));
    }

    private static int mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return 0;
        }
        return sortProcess(arr, 0, arr.length - 1);
    }


    private static int sortProcess(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return sortProcess(arr, l, mid) +
                sortProcess(arr, mid + 1, r) +
                merge(arr, l, r, mid);
    }

    private static int merge(int[] arr, int l, int r, int mid) {
        int[] help = new int[r - l + 1];
        int hi = 0;
        int p1 = l;
        int p2 = mid + 1;
        int res = 0;
        while (p1 <= mid && p2 <= r) {
            res += arr[p1] < arr[p2] ? arr[p1] * (r - p2 + 1) : 0;
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
        return res;
    }

}
