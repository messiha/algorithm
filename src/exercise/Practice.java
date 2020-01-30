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
        int[] arr = {5, 4, 3, 2, 6, 7, 8, 0, 0, 1};
        buildHeap(arr);
        System.out.println(Arrays.toString(arr));

    }

    private static void buildHeap(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //构建大根堆
            heapInsert(arr, i);
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    /**
     * 调整大根堆
     *
     * @param arr
     * @param index    数组中发生变化的下标
     * @param heapSize
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            //左子节点和右子节点比较出最大
            int largest = left + 1 < heapSize && arr[left] > arr[left + 1] ? left : left + 1;
            largest = arr[largest] > arr[index] ? largest : index;
            if (largest == index) {
                //head大于左右子节点
                break;
            }
            swap(arr, left, index);
            index = largest;
            left = 2 * index - 1;
        }

    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
