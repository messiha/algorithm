package src.exercise;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2020/12/22 16:45
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2, 6, 7, 8, 0, 0, 1};
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

        int size = arr.length;
        swap(arr, 0, --size);

        while (size > 0) {
            heapfy(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int biggest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            biggest = arr[index] < arr[biggest] ? biggest : index;
            if (biggest == index) {
                break;
            }
            swap(arr, index, biggest);
            index = biggest;
            left = index * 2 + 1;
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }


    /**
     * 交换位置
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
