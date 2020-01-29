/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter2;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2019/9/1 21:45
 */
public class QuickSort {
    /**
     * 改进后快排
     * 类比荷兰国旗问题
     * 额外时间复杂度O(1)
     */
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 1, 2, 3};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        //快排
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 在L R范围内快排
     */
    private static void quickSort(int[] arr, int L, int R) {
        if (L < R) {
            //随机快排
            swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
            int[] p = partition(arr, L, R);
            quickSort(arr, L, p[0] - 1);
            quickSort(arr, p[1] + 1, R);
        }
    }

    /**
     * 在L ~ R范围上 将小于target数字放在左，等于target数字放在中间，大于target数字放在右侧
     * 返回等于target部分下标起始位置和结束位置组成的数组(即等于区域下标起始-结束位置组成的数组)
     */
    private static int[] partition(int[] arr, int l, int r) {
        //定义less指针 代表小于target部分起始下标
        int less = l - 1;
        int more = r;
        while (l < more) {
            //假设数组最后一个位置的数为target   target=arr[r]
            if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else if (arr[l] > arr[r]) {
                //l下标数大于target，最后将target置于中间，所以--more
                swap(arr, --more, l);
            } else {
                //等于target情况
                l++;
            }
        }
        //交换 将 R位置的target 放置在 中间位置
        //交换前more位置数大于target,交换后more下标位置的数就是target，所以返回值 int[]{less + 1, more}
        swap(arr, more, r);
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
