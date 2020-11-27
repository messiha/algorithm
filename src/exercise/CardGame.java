package src.exercise;

/**
 * @author yan.zhang
 * @date 2020/11/27 上午11:06
 */
public class CardGame {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 100, 4};
        System.out.println(solutionByRecursion(arr));
    }

    private static int solutionByRecursion(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        return Math.max(f(arr, 0, arr.length - 1), s(arr, 0, arr.length - 1));
    }

    private static int f(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }
        return Math.max(arr[l] + s(arr, l + 1, r), arr[r] + s(arr, l, r - 1));
    }

    private static int s(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }
        return Math.min(f(arr, l + 1, r), f(arr, l, r - 1));
    }

}
