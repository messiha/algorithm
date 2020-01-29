/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter1;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2019/9/16 22:09
 */
public class SmallSum {
    /**
     * 小和问题
     * 在一个数组中，每一个数左边比当前数组小的数累加起来，叫做数组的小和，求一个数组的小和
     * ag：[1,3,4,2,5]
     * 1左侧比1小的数，无
     * 3左侧比3小的数 1
     * 4左侧比4小的数 1,3
     * ...
     * 小和为16
     * 类比：归并排序思想
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 3, 4, 2, 5}));
    }

    public static int solution(int arr[]) {
        if (null == arr || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static int mergeSort(int[] arr, int l, int r) {
        if (r == l) {
            return 0;
        }
        int mid = l + ((r - l) >> 1);
        return mergeSort(arr, l, mid) +
                mergeSort(arr, mid + 1, r) +
                merger(arr, l, mid, r);
    }

    private static int merger(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int ph = 0;
        int p1 = l;
        int response = 0;
        //右侧起始位置下标
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            //p1位置数若小于p2位置，则[p2,R]范围内所有数都比p1位置大，因为[p2,R]是升序排列好的
            response += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[ph++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //左侧和右侧有且仅有一部分会越界,两个while循环只有一个执行
        while (p1 <= mid) {
            //while循环结束，p1仍然小于等于mid,说明 p2越界
            help[ph++] = arr[p1++];
        }
        while (p2 <= r) {
            //p1越界
            help[ph++] = arr[p2++];
        }
        //help数组覆盖arr数组
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        System.out.println("help:" + Arrays.toString(help));
        return response;
    }

}
