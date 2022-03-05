package src.leetcode.dp;

/**
 * @author yan.zhang
 * @date 2022/3/5 10:27
 */
public class MaxSubArray {
    /**
     * https://leetcode-cn.com/problems/maximum-subarray/
     * 最大子数组和
     */
    public static void main(String[] args) {
//        int[] arr = new int[]{1};
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] arr = new int[]{-2, -1, -3, -4, -1};
        System.out.println(maxSubArray_04(arr));
    }

    /**
     * DP方式求解
     *
     * @param arr
     * @return
     */
    private static int maxSubArray(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int result = dp[0];
        //dp[i-1] 所以 i = 1开始,result 初始值记为arr[0]
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
            result = Math.max(dp[i], result);
        }
        return result;
    }

    /**
     * dp 求解
     * 空间优化
     *
     * @param arr
     * @return
     */
    private static int maxSubArray_02(int[] arr) {
        int dp = arr[0];
        int result = arr[0];

        for (int i = 1; i < arr.length; i++) {
            dp = Math.max(arr[i], arr[i] + dp);
            result = Math.max(result, dp);
        }
        return result;
    }

    /**
     * 贪心法求解
     *
     * @param arr
     * @return
     */
    private static int maxSubArray_03(int[] arr) {
        int result = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            result = Math.max(result, sum);

            if (sum < 0) {
                sum = 0;
            }
        }
        return result;
    }

    /**
     * 分治
     */
    private static int maxSubArray_04(int[] arr) {
        return maxSubArrayHelper(arr, 0, arr.length - 1);
    }

    private static int maxSubArrayHelper(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + ((r - l) >> 1);
        int leftSum = maxSubArrayHelper(arr, l, mid);
        int rightSum = maxSubArrayHelper(arr, mid + 1, r);
        int midSum = maxCrossingSubArray(arr, l, mid, r);
        return Math.max(Math.max(leftSum, rightSum), midSum);
    }

    private static int maxCrossingSubArray(int[] arr, int l, int mid, int r) {
        int ls = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= l; i--) {
            sum += arr[i];
            ls = Math.max(ls, sum);
        }
        sum = 0;
        int rs = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= r; i++) {
            sum += arr[i];
            rs = Math.max(rs, sum);
        }
        return ls + rs;
    }
}
