/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.exercise;

/**
 * @author yan.zhang
 * @date 2020/3/16 22:50
 */
public class RevolveArr {
    public static void main(String[] args) {
        int[] array = {4, 5, 6, 7, 8, 1, 2, 3};
        int min = minNumberInRotateArray(array);
        System.out.println(min);
    }

    private static int minNumberInRotateArray(int[] arr) {

        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] < arr[high]) {
                return arr[low];
            }
            int mid = low + ((high - low) >> 1);
            if (arr[mid] < arr[high]) {
                high = mid;
            } else if (arr[mid] > arr[low]) {
                low = mid + 1;
            } else {
                low++;
            }
        }
        return arr[low];
    }

}
