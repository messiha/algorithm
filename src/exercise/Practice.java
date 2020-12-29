/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.exercise;

/**
 * @author yan.zhang
 * @date 2019/9/17 18:34
 */


import java.util.Arrays;

/**
 * 代码练习
 */
public class Practice {

    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 6, 7, 8, 0, 0, 1, -9, 17};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void heapSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int heapSize = arr.length;
        swap(arr, --heapSize, 0);

        while (heapSize > 0) {
            heapify(arr, heapSize, 0);
            swap(arr, 0, --heapSize);
        }
    }

    private static void heapify(int[] arr, int heapSize, int index) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[largest] < arr[index] ? index : largest;

            if (largest == index) {
                break;
            }

            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[(index - 1) / 2] < arr[index]) {
            swap(arr, (index - 1) / 2, index);
            index = (index - 1) / 2;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}