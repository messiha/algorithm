/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter2;

/**
 * @author yan.zhang
 * @date 2019/10/5 17:46
 */

import java.util.Arrays;

/**
 * 堆排序：
 * 1）数组形成大根堆 (此时数组仍然无序)
 * 2）最后一个位置和堆顶交换 (最大值调整到堆最后一个位置)
 * 3）heapSize - 1 (剔除最大值)
 * 4) 重新调整为大根堆 执行heapify过程
 * 5）堆顶和现在最后一个位置数交换
 */
public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {6, 5, 4, 3};
        int[] arr = {5, 4, 3, 2, 6, 7, 8, 0, 0, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void heapSort(int[] arr) {
        if (null == arr || arr.length == 0) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = arr.length;
        //最后一个位置和堆顶交换,并将堆大小 -1
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            //调整成大根堆
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }

    }

    /**
     * 调整大根堆
     */
    private static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        //只要堆左子节点小于堆现在大小，循环继续
        while (left < heapSize) {
            /**
             * 注意这里不能是left + 1 < heapSize && arr[left] > arr[left + 1]
             *                     ? left
             *                     : left + 1;
             *因为left + 1 < heapSize 如果为false 则代表此时的堆不包含右子节点
             *此时这个三元表达式返回 left + 1 则这里错误
             *因为left + 1 < heapSize 如果 为false 只能返回 left下标 即左子节点
             */
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            largest = arr[largest] > arr[index] ? largest : index;
            //arr[largest] > arr[index] ? largest : index largest == index代表 index值大于左右child值，不需要"下沉"
            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
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
