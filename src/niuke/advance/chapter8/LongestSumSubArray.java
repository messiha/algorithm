/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter8;

/**
 * @author yan.zhang
 * @date 2020/12/6 17:53
 */
public class LongestSumSubArray {
    /**
     * 给定一个无序数组,全是正数，给定一个目标值aim，求累加和为aim的最长子数组。
     * 要求额外空间复杂度O(1),时间复杂度O(N)
     */

    /**
     * 双指针：其实位置为左侧，小于等于target R指针向右移动，大于targetL指针向右移动
     */

    public static void main(String[] args) {
        int[] arr = new int[]{7, 7, 3, 2, 1, 1, 7, 7};
        System.out.println(getMaxLength(arr, 7));
    }

    private static int getMaxLength(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int L = 0;
        int R = 0;

        //起始位置，L，R指针都在0位置。sum为0位置上的值
        int sum = arr[0];
        int len = 0;
        while (R < arr.length) {
            if (sum == target) {
                len = Math.max(len, R - L + 1);

                //等于情况下，L指针右移，则一定 sum<target,继续流程，否则流程无法继续
                sum -= arr[L++];
            } else if (sum < target) {
                R++;
                if (R == arr.length) {
                    break;
                }
                sum += arr[R];
            } else {
                //sum >= target
                sum -= arr[L++];
            }
        }

        return len;
    }


    /**
     * 给定一个无序数组,可正，可负，可0，给定一个目标值aim，求累加和小于等于aim的，最长子数组。要求时间复杂度O(N)
     */

    /**
     * 思路：
     * 子数组：必须连续
     * 使用两个辅助数组：
     * 1.min_sum[]: 每个下标值代表，以该下标位置向右能加出的最小累加和
     * 2.min_sum_index[]:该下标值对应min_sum[]中最小累加和的右边界
     */

}
