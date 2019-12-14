/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2019/11/4 12:02
 */
public class Practice2 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 6, 7, 8, 0, 0, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
//        buildHeap(arr);
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        //只要堆左子节点小于堆现在大小，循环继续
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            swap(arr, index, largest);
            index = left;
            left = 2 * index + 1;
        }
    }

    private static void buildHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > arr[(i - 1) / 2]) {
                swap(arr, i, (i - 1) / 2);
                i = (i - 1) / 2;
            }
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
