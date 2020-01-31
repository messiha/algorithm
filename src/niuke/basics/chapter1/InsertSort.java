package src.niuke.basics.chapter1;

/**
 * 插入排序，假设左端已经有序，从左起第一个元素开始，与有序端比较
 * 最坏时间复杂度：o(n^2)
 * 最优时间复杂度:o(n)   对于有序序列
 * 稳定性：稳定
 */
public class InsertSort {
    public static void insertSort3(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i != arr.length; i++) {
            for (int j = i; j != 0; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j, j - 1);
                }
            }
        }
    }


    //方式一
    public static void insertSort1(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        //假定右侧为无序序列，从右侧取出,极值取到数组最后一位
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    j--;
                }
            }
        }
    }

    //方式二
    public static void insertSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) { //假定右侧为无序序列，从右侧取出,极值取到数组最后一位
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }


    //交换i,j
    public static void swap(int[] arr, int i, int j) {
        int temp = 0;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 1, 9, 0, 4, 6};
        insertSort3(arr);
        for (int item : arr) {
            System.out.print(item);
        }
    }
}
