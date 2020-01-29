package src.niuke.basics.chapter1;


/**
 * 选择排序：选择最小的和第一个位置交换，选择次小的和第二个位置交换...
 * 时间复杂度：O(n^2)
 */
public class SelectedSort {

    public static void selectedSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        //两个数需要选择1次，n个数需要选择n-1次
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//假设下标为0的位置上的元素为最小值, 依次与数组后的数据比较找出最小值的下标用min记录
            for (int j = i + 1; j < arr.length; j++) { //从i+1位置开始，可以取到数组中最后一位数
                //修改minIndex下标
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr, minIndex, i);
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
        int[] arr = {5, 4, 3, 2, 1};
        selectedSort(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }
}
