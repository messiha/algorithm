/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.exercise;

import java.util.LinkedList;

/**
 * @author yan.zhang
 * @date 2020/6/24 16:53
 */
public class MaxWindow {
    public static void main(String[] args) {

    }

    private static int[] getMaxInWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<>();

        int index = 0;
        int[] res = new int[arr.length - w + 1];

        for (int i = 0; i < arr.length; i++) {
            while (!list.isEmpty() && arr[i] >= arr[list.peekLast()]) {
                list.pollLast();
            }
            list.addLast(i);

            //clean past element
            if (list.peekFirst() == i - w) {
                list.pollFirst();
            }

            //collect list head
            if (i + 1 >= w) {
                res[index++] = arr[list.peekFirst()];
            }
        }
        return res;
    }
}
