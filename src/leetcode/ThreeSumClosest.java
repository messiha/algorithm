package src.leetcode;

import java.util.Arrays;

/**
 * @Author yan.zhang
 * @Date 2022/2/24 10:37
 * @Version 1.0
 */
public class ThreeSumClosest {
    /**
     * https://leetcode-cn.com/problems/3sum-closest/
     * 最接近的三数之和
     */
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 2, 1, -4};
        int target = 1;
        System.out.println(solution(nums, target));
    }

    private static int solution(int[] nums, int target) {
        Arrays.sort(nums);

        //ans记录结果
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int start = i + 1, end = nums.length - 1;

            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];

                //如果sum 更接近 target 替换
                if (Math.abs(target - ans) > Math.abs(target - sum)) {
                    ans = sum;
                }

                //继续流程，判断指针移动方向
                if (target > sum) {
                    start++;
                } else if (target < sum) {
                    end--;
                } else {
                    //相等直接返回
                    return sum;
                }
            }
        }

        return ans;

    }
}
