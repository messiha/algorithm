package src.leetcode;

/**
 * @author yan.zhang
 * @date 2019/9/5 16:24
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int[] results = Solution(nums, 6);
        System.out.println(Arrays.toString(results));
    }

    /**
     * 字典法
     */
    private static int[] SolutionByDict(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return result;
    }

    /**
     * 不推荐
     * 画图理解
     * 缺点：nums如果存在很大的数，需要创建一个很大的tempArray数组
     */
    private static int[] Solution(int[] nums, int target) {
        //构建临时数组
        int[] tempArray = new int[200];
        //赋初值
        for (int i = 0; i < tempArray.length; i++) {
            tempArray[i] = -1;
        }
        //定义返回结果数组
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (-1 != tempArray[temp]) {
                result[0] = tempArray[temp];
                result[1] = i;
            }
            //nums数组的值作为tempArray的下标，tempArray的值为i，最终返回tempArray[temp]
            tempArray[nums[i]] = i;
        }
        return result;
    }


}
