package src.niuke.advance.chapter4;


/**
 * 累加和问题：
 * 给定一个无序数组（数组中可能包含，正数，负数），给定一个目标值aim，求累加和为aim的最长子数组。
 * ag：7,7,3,2,1,1,7,7 aim = 7 累加和为7的最长子数组为[3,2,1,1]
 * <p>
 * <p>
 * <p>
 * 思路：
 * 子数组，子串问题...
 * 子数组，子串最终会以某个位置结尾，求出以每个位置结尾的情况下的累加和
 * <p>
 * <p>
 * 变量sum：记录0位置到当前位置（i位置）的累加和
 * ag：aim = 800，从0位置到第1000位置，此时sum = 2000 ，根据思路，求以1000这个位置结尾的数，累加和为800的最长子数组。
 * 此时需要知道，从0位置开始，第一次累加和达到1200的位置，假设为p，则从[p+1,1000]这段子数组一定是，以1000结尾，累加和为800的最长子数组。
 */

import java.util.HashMap;
import java.util.Map;

/**
 * @author yan.zhang
 * @date 2020/8/9 11:30
 */
public class LongestSumSubArray {

    //7,7,3,2,1,1,7,-6,-1,7

    //Map中记录第一次累加和
    public static void main(String[] args) {
        int[] arr = new int[]{7, 7, 3, 2, 1, 1, 7, -6, -1, 7};

        System.out.println(maxLength(arr, 7));
    }

    private static int maxLength(int[] arr, int target) {
        //key:累加和，value：累加和第一次出现的位置  如果累加和第二次出现不更新map
        Map<Integer, Integer> map = new HashMap<>();
        //初始累加和为0，记为-1
        map.put(0, -1);

        int len = 0;

        //每个位置相加
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum - target)) {
                len = Math.max(i - map.get(sum - target), len);
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }


    /**
     * 扩展问题：
     * 一个数组中，有奇数有偶数，求奇数和偶数相等的最长子数组。
     *
     * 将奇数修改为1，偶数修改为-1，转换为求累加和为0的最长子数组
     * 原因：处理后数组中只有1和-1，累加和为0说明奇数和偶数数量相等
     *
     * 类似问题:
     * 一个数组中包含0，1，2求该数组中含有1和含有2的最长子数组。将该数组中2修改为-1。
     */
}
