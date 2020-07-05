/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter2;

import java.util.LinkedList;

/**
 * @author yan.zhang
 * @date 2020/6/21 18:38
 */
public class MaxWindowSubArray {
    /**
     * 给定数组arr和整数num，共返回有多少个子数组满足如下情况：
     * max(arr[i...j]) - min(arr[i...j]) <= num
     * max(arr[i...j])表示子数组arr[i...j]中的最大值，min(arr[i...j])表示子数组arr[i...j]中的最小值
     * 要求：如果数组长度为N，请实现时间复杂度为O（N）的解法。
     */
    public static void main(String[] args) {
        /**
         * 思路：
         * 1.在某段L~R范围内的数组里，如果L~R范围内满足max(arr[i...j]) - min(arr[i...j]) <= num
         * 则L~R的所有子数组均满足max(arr[i...j]) - min(arr[i...j]) <= num
         *
         * 2.在某段L~R范围内的数组里，如果L~R范围内不满足上述，R扩展产生的子数组均不满足
         * 因为max - min >= num,扩大R则只可能 max增大,min减小 ，任然max - min >= num
         *
         */
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(allSubArrayByForce(arr, 10));
        System.out.println(allSubArray(arr, 10));
    }

    private static int allSubArray(int[] arr, int target) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qMax = new LinkedList<>();
        LinkedList<Integer> qMin = new LinkedList<>();

        int L = 0;
        int R = 0;
        int res = 0;

        while (L < arr.length) {
            while (R < arr.length) {
                while (!qMin.isEmpty() && arr[qMin.peekLast()] >= arr[R]) {
                    qMin.pollLast();
                }
                qMin.addLast(R);
                while (!qMax.isEmpty() && arr[qMax.peekLast()] <= arr[R]) {
                    qMax.pollLast();
                }
                qMax.addLast(R);

                if (arr[qMax.peekFirst()] - arr[qMin.peekFirst()] > target) {
                    break;
                }
                R++;
            }
            //L下标需要右移，检查最大/最小队列中 最大值下标和最小值下标(即首个node)是否需要更新
            if (qMin.peekFirst() == L) {
                qMin.pollFirst();
            }
            if (qMax.peekFirst() == L) {
                qMax.pollFirst();
            }

            //计算 L ~ R 范围内符合通项式的数量
            res += R - L;
            L++;
        }
        return res;
    }


    //对数器
    private static int allSubArrayByForce(int[] arr, int target) {
        int res = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                if (isValid(arr, start, end, target)) {
                    res++;
                }
            }

        }
        return res;
    }

    private static boolean isValid(int[] arr, int start, int end, int target) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);

        }
        return max - min <= target;
    }
}
