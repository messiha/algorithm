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
        int[] arr1 = new int[]{1, 3, 5, 2, 2};
       /* int[] arr2 = new int[]{1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
        System.out.println(findKth(arr2, 49, 24));
        System.out.println(Arrays.toString(arr2));*/

        findKthByHeap(arr1, 0, 0);
        System.out.println(Arrays.toString(arr1));
    }


    /**
     * 类比快排，但是在每一次partition之后使用二分查找，减少一般的排序
     *
     * @param arr
     * @param n
     * @param K
     * @return
     */
    private static int findKth(int[] arr, int n, int K) {
        return 0;
    }

    private static int findKthByHeap(int[] arr, int n, int K) {
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int size = arr.length;

        swap(arr, 0, --size);

        while (size > 0) {
            //找第K大则只需要调整K次
            heapify(arr, 0, size);
            swap(arr, 0, --size);

        }
        return 0;

    }

    private static void heapify(int[] arr, int size, int i) {
        int left = i * 2 + 1;
        while (left < size) {
            int small = left + 1 < size && arr[left] < arr[left + 1] ? arr[left] : arr[left + 1];
            small = arr[i] < arr[small] ? i : small;

            if (small == i) {
                break;
            }

            swap(arr, small, i);
            i = small;
            left = i * 2 + 1;
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
