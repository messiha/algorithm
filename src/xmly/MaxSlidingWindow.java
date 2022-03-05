package src.xmly;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author yan.zhang
 * @Date 2021/11/30 17:48
 * @Version 1.0
 */
public class MaxSlidingWindow {
    /**
     * 求滑动窗口最大值
     * [3,3,5,5,6,7]
     */
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] ints = MaxSlidingWindow.solution(nums, 3);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] solution(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            //保证队列是由大到小的顺序，对每个进入队列的值，和队列尾值比较,如果大于，剔除队列尾
            while (!list.isEmpty() && arr[list.peekLast()] <= arr[i]) {
                list.pollLast();
            }
            //队尾进
            list.addLast(i);

            if (i - w == list.peekFirst()) {
                list.pollFirst();
            }

            //取窗口最大值，这里要检查窗口是否形成
            if (i + 1 >= w) {
                res[index++] = arr[list.peekFirst()];
            }
        }

        return res;
    }

}
