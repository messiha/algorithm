package src.off.heap;

import java.util.Arrays;

/**
 * @author yan.zhang
 * @date 2020/12/22 16:10
 */
public class FindKth {
    /**
     * 有一个整数数组，请你根据快速排序的思路，找出数组中第K大的数。
     * 给定一个整数数组a,同时给定它的大小n和要找的K(K在1到n之间)，请返回第K大的数，保证答案存在。
     * <p>
     * 输入 [1,3,5,2,2],5,3 输出2
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr2 = new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
//        System.out.println(findKthByHeap(arr2, 49, 24));
        System.out.println(findKth(arr2, 49, 24));
        System.out.println(Arrays.toString(arr2));
    }


    /**
     * 类比快排，但是在每一次partition之后使用二分查找，减少一般的排序
     */
    private static int findKth(int[] arr, int n, int K) {
        return findK(arr, 0, n - 1, K);
    }

    private static int findK(int[] arr, int left, int right, int k) {
        while (left < right) {
            int pivot = partition(arr, left, right);
            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot < k - 1) {
                return findK(arr, pivot + 1, right, k);
            } else if (pivot > k - 1) {
                return findK(arr, left, pivot - 1, k);
            }
        }
        return -1;
    }

    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }


    /**
     * 方式二：
     * 根据堆排序的思路。做升序排序，可以做到只排序到K位置以及K之后的位置，可以找出解
     */
    private static int findKthByHeap(int[] arr, int n, int K) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }
        int heapSize = n;
        //最后一个位置和堆顶交换,并将堆大小 -1
        swap(arr, 0, --heapSize);

        //
        while (heapSize > 0 && K > 0) {
            heapify(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
            K--;
        }

        return arr[heapSize + 1];
    }

    private static void heapify(int[] arr, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left + 1] > arr[left]
                    ? left + 1
                    : left;
            largest = arr[largest] > arr[index] ? largest : index;

            if (largest == index) {
                break;
            }
            swap(arr, index, largest);
            index = largest;
            left = 2 * index + 1;
        }

    }

    /**
     * 由小到大升序排列，建立大根堆
     *
     * @param arr
     * @param index
     */
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
