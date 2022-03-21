package src.leetcode.array;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2022/3/21 20:42
 */
public class TwoSumArrayIsSorted {
    /**
     * https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/
     * 两数之和II-输入有序数组
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ints = twoSum(arr, target);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] twoSum(int[] arr, int target) {
        int[] ans = new int[2];
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < target) {
                left++;
            } else if (arr[left] + arr[right] > target) {
                right--;
            } else {
                ans[0] = left + 1;
                ans[1] = right + 1;
                return ans;
            }
        }
        return ans;
    }
}
