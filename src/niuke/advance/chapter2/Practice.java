package src.niuke.advance.chapter2;

import java.util.LinkedList;

/**
 * @author yan
 * @date 2020/6/2823:02
 */
public class Practice {
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println(getMaxByForce(arr, -1));
        System.out.println(getMax(arr, -1));
    }

    private static int getMax(int[] arr, int target) {
        int L = 0;
        int R = 0;
        int res = 0;
        LinkedList<Integer> max = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();

        while (L < arr.length) {
            while (R < arr.length) {
                while (!max.isEmpty() && arr[max.peekLast()] <= arr[R]) {
                    max.pollLast();
                }
                max.addLast(R);
                while (!min.isEmpty() && arr[min.peekLast()] >= arr[R]) {
                    min.pollLast();
                }
                min.addLast(R);
                if (arr[max.peekFirst()] - arr[min.peekFirst()] > target) {
                    break;
                }
                R++;
            }

            if (max.peekFirst() == L) {
                max.pollFirst();
            }
            if (min.peekFirst() == L) {
                min.pollFirst();
            }
            res += R - L;
            L++;
        }
        return res;
    }

    private static int getMaxByForce(int[] arr, int target) {
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
