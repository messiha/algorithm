package src.xmly;

/**
 * @Author yan.zhang
 * @Date 2021/11/22 15:42
 * @Version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println(BinarySearch.recursiveMethod(arr, 0, arr.length - 1, 3));
        System.out.println(BinarySearch.nonRecursiveMethod(arr, 0, arr.length - 1, 3));
    }

    private static int nonRecursiveMethod(int[] arr, int lo, int hi, int target) {
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else if (arr[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    private static int recursiveMethod(int[] arr, int lo, int hi, int target) {
        if (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < target) {
                return recursiveMethod(arr, mid + 1, hi, target);
            } else if (arr[mid] > target) {
                return recursiveMethod(arr, lo, mid - 1, target);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }


}
