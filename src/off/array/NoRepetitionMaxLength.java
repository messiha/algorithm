/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yan.zhang
 * @date 2020/12/26 16:27
 */
public class NoRepetitionMaxLength {
    /**
     * 给定一个数组arr，返回arr的最长的无重复子串的长度(无重复指的是所有数字都不相同)。
     * 输入:[2,3,4,5] 输出:4
     * 输入:[2,2,3,4,3] 输出:3
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 4, 3};
        System.out.println(maxLength(arr));
    }

    public static int maxLength(int[] arr) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>(16);

        for (int start = 0, end = 0; end < arr.length; end++) {
            if (map.containsKey(arr[end])) {
                /**
                 * 找到以arr[end]结尾的最长子串，然后max保持最大长度，当某个数在之前出现过，
                 * 这个时候就把子串的起点start往后推一个，但是有一种情况，比如1，2，3，4，3，5，1。到第二个3时，
                 * 以后的子串起点start为4，到第二个1时，如果不取最大的start，按start = map.get(arr[end])+1
                 * 算出起点start为2，显然以起点start=2，结尾end=1的子串234351有重复的，因此start要取最大的
                 */
                start = Math.max(start, map.get(arr[end]) + 1);
            }

            res = Math.max(res, end - start + 1);
            map.put(arr[end], end);
        }

        return res;
    }
}
