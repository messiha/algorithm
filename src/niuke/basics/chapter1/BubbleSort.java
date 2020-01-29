package src.niuke.basics.chapter1;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(arr);
        for (int item : arr) {
            System.out.println(item);
        }
    }

    public static void bubbleSort(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = 0;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}



