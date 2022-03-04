package src.leetcode.array;

/**
 * @Author yan.zhang
 * @Date 2022/3/4 10:32
 * @Version 1.0
 */
public class KthLargestInArray {
    /**
     * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
     * 寻找第K大元素
     */
    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, -1, 1, 8, 10, 5, 6, 4};
        System.out.println(findKth(arr, 2));
    }

    private static int findKth(int[] arr, int k) {
        return findKthByHeap(arr, k);
    }

    private static int findKthByHeap(int[] arr, int k) {
        int heapSize = arr.length;
        for (int i = 0; i < heapSize; i++) {
            buildMaxHeap(arr, i);
        }

        for (int i = arr.length - 1; i >= arr.length - k + 1; --i) {
            //最后一个位置和0位置交换,堆调平衡
            //交换后最后一个位置，为最大值
            swap(arr, 0, i);
            --heapSize;
            maxHeapfy(arr, 0, heapSize);
        }

        return arr[0];
    }

    private static void buildMaxHeap(int[] arr, int i) {
        while (arr[i] > arr[(i - 1) / 2]) {
            swap(arr, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void maxHeapfy(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapfy(a, largest, heapSize);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
