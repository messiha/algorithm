package src.leetcode.array;

import java.util.Arrays;

/**
 * @Author yan.zhang
 * @Date 2022/3/4 15:41
 * @Version 1.0
 */
public class FindDuplicateNumber {
    /**
     * https://leetcode-cn.com/problems/find-the-duplicate-number/
     * 寻找重复数
     */
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(arr));
    }

    private static int findDuplicate(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return -1;
    }
}
