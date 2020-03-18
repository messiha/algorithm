/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter1;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2019/5/26 14:19
 */
public class MergeSort {
    /**
     * 归并排序
     * 时间复杂度：N*logN
     * 额外空间复杂度 O(N)
     * 递归(分治)思想
     * 稳定
     */

    private static void mergeSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        sortProcess(arr, 0, arr.length - 1);
    }

    private static void sortProcess(int[] arr, int L, int R) {
        //递归中止条件
        if (L == R) {
            return;
        }
        //等同于(L + R) / 2  L+R可能产生溢出问题，即大于int所能表示最大值   L + ((R - L) >> 1)
        int mid = L + ((R - L) >> 1);
        //递归，子过程 在0-mid范围排好序
        sortProcess(arr, 0, mid);
        sortProcess(arr, mid + 1, R);
        //L-mid范围排好序，mid-R范围排好序，merge函数让总体都有序
        merge(arr, L, mid, R);

    }

    private static void merge(int[] arr, int L, int mid, int R) {
        //1.辅助数组 R-L范围有多少数，生成一个同样大小的数组
        int[] help = new int[R - L + 1];
        //i 是help数组下标指针
        int i = 0;
        //2.指针p1 指向L位置下标  p2是右侧部分起始位置下标，因为 左右部分都有序，所以P1指针所在位置为左侧部分最小值
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= R) {
            //3.比较p1下标和p2下标位置数据大小 将小值存放入help数组
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        //4.左部分和右部分有且仅有一个越界，将未越界部分拷贝进原数组arr，两个while循环只有一个执行
        while (p1 <= mid) {
            //p1没越界，p2越界,p1拷贝进原数组
            help[i++] = arr[p1++];
        }
        while (p2 <= R) {
            help[i++] = arr[p2++];
        }
        //5.将help数组中的有序数copy到arr中 覆盖原来arr
        for (i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        System.out.println("help: " + Arrays.toString(help));
    }

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 1};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
