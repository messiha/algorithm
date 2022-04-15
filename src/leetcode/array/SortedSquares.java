package src.leetcode.array;

/**
 * @author yan.zhang
 * @date 2022/4/15 19:58
 */
public class SortedSquares {
    /**
     * https://leetcode-cn.com/problems/squares-of-a-sorted-array/
     * 有序数组的平方
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        sortedSquares(nums);
    }

    private static int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int low = 0, high = nums.length - 1;
        int index = nums.length - 1;
        while (low <= high) {
            if (Math.abs(nums[low]) < Math.abs(nums[high])) {
                ans[index--] = nums[high] * nums[high];
                high--;
            } else {
                ans[index--] = nums[low] * nums[low];
                low++;
            }
        }
        return ans;
    }

}
