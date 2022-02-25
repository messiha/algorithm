package src.leetcode.trace;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author yan.zhang
 * @Date 2022/2/22 18:00
 * @Version 1.0
 */
public class Permutations {
    /**
     * https://leetcode-cn.com/problems/permutations/
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列。
     *
     * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     */
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        solution_01(ints);
    }


    /**
     * 深度优先遍历
     * <p>
     * 层级、深度：level
     * 已选择的数：path
     * 记录是否已选择：used[]
     *
     * @return
     */

    private static List<List<Integer>> solution_01(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[len];

        dfs(nums, len, 0, path, used, res);

        return res;
    }

    private static void dfs(int[] ints, int len, int depth, Stack<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.push(ints[i]);
            used[i] = true;

            dfs(ints, len, depth + 1, path, used, res);

            //回溯
            path.pop();
            used[i] = false;
        }
    }

}
