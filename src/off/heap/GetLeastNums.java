package src.off.heap;

/**
 * @author yan.zhang
 * @date 2020/12/30 17:47
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 输入：[4,5,1,6,2,7,3,8],4
 * 输出：[1,2,3,4]
 */
public class GetLeastNums {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 6, 2, 7, 3, 8};
        ArrayList<Integer> integers = GetLeastNumbers_Solution(arr, 4);
        System.out.println(integers.toString());
        System.out.println(Arrays.toString(arr));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        if (input == null || input.length == 0 || k < 1) {
            return result;
        }

        for (int i = 0; i < input.length; i++) {
            heapInser(input, i);
        }

        int heapSize = input.length;
        swap(input, --heapSize, 0);


        while (heapSize > input.length - k) {
            heapify(input, 0, heapSize);
            swap(input, 0, --heapSize);
        }

        //build result
        for (int i = input.length - 1; i >= k; i--) {
            result.add(input[i]);
        }

        return result;

    }

    private static void heapify(int[] input, int i, int heapSize) {
        int left = 2 * i + 1;
        while (left < heapSize) {
            int least = left + 1 < heapSize && input[left] > input[left + 1] ? left + 1 : left;
            least = input[i] < input[least] ? i : least;

            if (i == least) {
                break;
            }

            swap(input, least, i);
            i = least;
            left = 2 * i + 1;
        }
    }

    private static void heapInser(int[] input, int i) {
        while (input[(i - 1) / 2] > input[i]) {
            swap(input, (i - 1) / 2, i);
            i = (i - 1) / 2;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
