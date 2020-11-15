/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author yan.zhang
 * @date 2020/11/8 20:12
 */
public class Demo {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        int[] ints = twoSolution(nums, 9);
        System.out.println(Arrays.toString(ints));
    }

    private static int[] twoSolution(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>(8);

        for (int i = 0; i < nums.length; i++) {
            if (map.get(target - nums[i]) == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, map.get(target - nums[i])};
            }
        }
        return null;
    }
}
