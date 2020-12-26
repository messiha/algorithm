/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off.heap;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2020/12/26 20:14
 */
public class FindKthByQuickSort {
    public static void main(String[] args) {
        int[] arr2 = new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
//        int[] arr2 = new int[]{7, 10, 3, 2, 1, 1, 14, -6, -1, 0};
        System.out.println(findKth(arr2, 0, 24));
        System.out.println(Arrays.toString(arr2));
    }


    private static int findKth(int[] arr, int n, int K) {
        return findK(arr, 0, arr.length - 1, K);
    }

    private static int findK(int[] arr, int l, int r, int k) {
        //如果要使用这种解法，这里必须l<=r
        if (l <= r) {
            swap(arr, r, l + (int) (Math.random() * (r - l + 1)));

            int[] p = partition(arr, l, r);

            if (k - 1 == p[0] || k - 1 == p[1]) {
                return arr[p[0]];
            } else if (k - 1 > p[1]) {
                return findK(arr, p[1] + 1, r, k);
            } else if (k - 1 < p[0]) {
                return findK(arr, l, p[0] - 1, k);
            }

        }
        return -1;
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        int more = r;
        while (l < more) {
            if (arr[l] > arr[r]) {
                swap(arr, l++, ++less);
            } else if (arr[l] < arr[r]) {
                swap(arr, l, --more);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
