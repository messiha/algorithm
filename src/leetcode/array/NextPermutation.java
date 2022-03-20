package src.leetcode.array;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2022/3/20 18:53
 */
public class NextPermutation {
    /**
     * 下一个排列
     * https://leetcode-cn.com/problems/next-permutation/
     */
    public static void main(String[] args) {
//        int[] arr = new int[]{1, 2, 4, 6, 5};
//        int[] arr = new int[]{1, 2, 3};
        int[] arr = new int[]{3, 2, 1};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 我们可以将该问题形式化地描述为：给定若干个数字，将其组合为一个整数。如何将这些数字重新排列，以得到下一个更大的整数。
     * 如 123 下一个更大的数为 132。如果没有更大的整数，则输出最小的整数。
     * <p>
     * https://leetcode-cn.com/problems/next-permutation/solution/xia-yi-ge-pai-lie-suan-fa-xiang-jie-si-lu-tui-dao-/
     *
     * @param arr
     */
    private static void nextPermutation(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int i = len - 1, pre = len - 2, k = len - 1;
        //i为当前下标,从后向前找到第一组升序排列arr[pre,i]
        while (pre >= 0 && arr[i] <= arr[pre]) {
            i--;
            pre--;
        }

        //假设[3,2,1]从后向前，不存在升序关系的两个数
        if (pre >= 0) {
            //从pre位置向后查找,搜寻，即arr[pre]为"小数"，arr[k]为"大数"
            while (arr[k] <= arr[pre]) {
                k--;
            }
            swap(arr, k, pre);
        }

        //交换后,将[i,end]段的数字翻转
        int end = len - 1;
        while (i < end) {
            swap(arr, i++, end--);
        }
    }

    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k] = arr[i];
        arr[i] = tmp;
    }
}
