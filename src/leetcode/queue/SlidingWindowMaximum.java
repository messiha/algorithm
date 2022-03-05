package src.leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yan.zhang
 * @date 2022/3/5 20:06
 */
public class SlidingWindowMaximum {
    /**
     * https://leetcode-cn.com/problems/sliding-window-maximum/
     * 滑动窗口最大值
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        maxSlidingWindow(arr, 3);
    }

    /**
     * 思路：
     * 单调队列，队列内维护可能成为最大值的元素
     *
     * @param arr
     * @param k
     * @return
     */
    private static int[] maxSlidingWindow(int[] arr, int k) {
        if (null == arr || k < 1) {
            return null;
        }
        int len = arr.length;
        int[] result = new int[len - k + 1];
        Deque<Integer> list = new LinkedList<>();
        int ri = 0;
        int i = 0;

        while (i < len) {
            while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                list.pollLast();
            }
            list.offerLast(i);
            //这个Deque保存的是数组下标，判断数组若保留"头"是否大于窗口大小
            if (i - k == list.peekFirst()) {
                list.pollFirst();
            }

            //若窗口形成则取Deque头
            if (i + 1 >= k) {
                result[ri++] = arr[list.peekFirst()];
            }
            i++;
        }
        return result;

    }
}
