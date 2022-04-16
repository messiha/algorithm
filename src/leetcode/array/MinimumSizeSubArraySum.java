package src.leetcode.array;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2022/4/16 10:16
 */
public class MinimumSizeSubArraySum {
    /**
     * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
     * 长度最小子数组
     */
    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubArrayLen(nums, 11));
    }

    /**
     * 双指针模拟滑动窗口
     *
     * @param nums
     * @param target
     * @return
     */
    private static int minSubArrayLen(int[] nums, int target) {
        int left = 0, right = 0, sum = 0, min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= target) {
                //大于等于target,此时得到数组连续长度
                //注意nums[right++];right已经+1,right-left即得到长度
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    /**
     * 二分查找思路
     */
    private static int minSubArrayLen_02(int[] nums, int target) {
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        int[] sums = new int[len + 1];
        //init
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }

        //sums为递增数组，寻找sum[j] + target <= sum[k]
        for (int i = 0; i < sums.length; i++) {
            int t = target + sums[i];
            int index = Arrays.binarySearch(sums, t);
            //(~x) = -(x + 1),这里是处理binarySearch搜寻结果，如果不存在返回值为-(insertion point -1)
            if (index < 0) {
                index = ~index;
            }
            if (index <= len) {
                min = Math.min(min, index - i);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
