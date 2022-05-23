package src.leetcode.array;

import java.util.HashMap;

/**
 * @Author yan.zhang
 * @Date 2022/5/23 23:41
 * @Version 1.0
 */
public class LongestConsecutiveSequence {
    /**
     * 最长连续序列
     * https://leetcode.cn/problems/longest-consecutive-sequence/
     */
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        int ans = solution(nums);
        System.out.println(ans);
    }

    private static int solution(int[] nums) {
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        for (int num : nums) {
            if (!map.containsKey(num)) {
                int right = map.getOrDefault(num + 1, 0);
                int left = map.getOrDefault(num - 1, 0);
                //当前长度
                int cur = left + right + 1;
                max = Math.max(cur, max);

                //更新当前数的长度
                map.put(num, cur);
                //更新端点值
                //[1,3,2,4],当遍历到4，需要更新端点，此时端点为1和4，因为2和3已经出现在哈希表，下次不会进入if分支，不做计算。
                //如果是[1,3,2,5,4]此时需要更新的就是端点1和5的值
                map.put(num - left, cur);
                map.put(num + right, cur);
            }
        }
        return max;
    }
}
