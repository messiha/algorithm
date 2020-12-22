package src.exercise;

/**
 * @author yan.zhang
 * @date 2020/12/21 16:29
 */
public class MaxsumofSubarray {
    /**
     * 给定一个数组arr，返回子数组的最大累加和
     * 例如，arr = [1, -2, 3, 5, -2, 6, -1]，所有子数组中，[3, 5, -2, 6]可以累加出最大的和12，所以返回12.
     * [要求]
     * 时间复杂度为O(n)O(n)，空间复杂度为O(1)O(1)
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, 5, -2, 6, -1};
        int max = maxsumofSubarrayByForce(arr, arr.length - 1);

        System.out.println(maxsumofSubarray(arr));

//      int max = maxsumofSubarray(arr);
    }

    /**
     * 以0位置结尾的最大累加和
     * 以1位置结尾的最大累加和
     * 该方法错误 后续考虑递归...
     */
    private static int max = 0;

    private static int maxsumofSubarrayByForce(int[] arr, int end) {
        if (end <= 0) {
            return arr[0];
        }
        max = Math.max(max, max + arr[end]);
        return Math.max(max, maxsumofSubarrayByForce(arr, end - 1));
    }


    /**
     * 解题思路就是从前往后推，要保证每个位置的值都起码比原本的大。注意每次都要用m保存当前时刻的最大累积和，最后直接返回就ok。
     *
     * @param arr
     * @return
     */
    private static int maxsumofSubarray(int[] arr) {
        //保存当前最大累加和
        int m = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.max(arr[i], arr[i] + arr[i - 1]);
            m = Math.max(m, arr[i]);
        }

        return m;
    }

}
