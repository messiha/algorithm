/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter1;

/**
 * @author yan.zhang
 * @date 2019/10/4 16:25
 */

import java.util.Arrays;

/**
 * 逆序对问题：
 * 在一个数组中，左边的数如果比右边的大，则两个数构成一个逆序对，请打印所有逆序对
 * 思路：类比归并排序问题
 * <p>
 */
public class ReverseNum {

    public static void main(String[] args) {
            int[] arr = {5, 4, 3, 2, 1};
//      int[] arr = {1, 2, 3, 4, 5};
        process(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, 0, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;
        while (p1 <= mid && p2 <= R) {
            //p1位置数若小于p2位置，则[p2,R]范围内所有数都比p1位置大，因为[p2,R]是升序排列好的
            if (arr[p1] > arr[p2]) {
                for (int j = p1; j <= mid; j++) {
                    System.out.println("[" + arr[j] + "," + arr[p2] + "]");
                }
            }
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //p1越过mid 或 p2越过R
        while (p1 <= mid) {
            //p2越过R
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        //help数组copy覆盖原数组
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
//        System.out.println("help:" + Arrays.toString(help));
    }
}
