package src.leetcode.trace;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Author yan.zhang
 * @Date 2022/2/25 20:08
 * @Version 1.0
 */
public class PermutationsII {
    /**
     * https://leetcode-cn.com/problems/permutations-ii/
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * https://leetcode-cn.com/problems/permutations-ii/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liwe-2/
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        solution(nums);
    }

    private static List<List<Integer>> solution(int[] nums) {
        //排序，目的是剪枝
        Arrays.sort(nums);

        int len = nums.length;
        boolean[] used = new boolean[len];
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs(nums, len, 0, used, stack, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth, boolean[] used, Stack<Integer> stack, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }

            //剪枝
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            stack.push(nums[i]);
            used[i] = true;

            dfs(nums, len, depth + 1, used, stack, res);

            stack.pop();
            used[i] = false;
        }
    }
}
