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
     * 排列：无顺序性
     * <p>
     * https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-python-dai-ma-java-dai-ma-by-liweiw/
     */
    public static void main(String[] args) {
        int[] ints = {1, 3, 2};
        solution_01(ints);
    }


    /**
     * 深度优先遍历
     * <p>
     * 层级、深度：level
     * 已选择的数：path
     * 记录是否已选择：used[]
     */
    private static List<List<Integer>> solution_01(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        Stack<Integer> path = new Stack<>();
        boolean[] used = new boolean[len];

//        dfs_0(nums, len, 0, path, used, res);
        dfs_1(nums, len, 0, path, used, res);

        return res;
    }


    //深度优先+不回溯

    private static void dfs_1(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res) {
        if (depth == len) {
            //每一层传递下来的 path 变量都是新建的
            res.add(path);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            //没有被使用
            if (!used[i]) {
                //newPath保存上次
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(nums[i]);
                //每一次尝试都创建新的变量表示当前的"状态"
                boolean[] newUsed = new boolean[len];
                System.arraycopy(used, 0, newUsed, 0, len);

                newUsed[i] = true;

                dfs_1(nums, len, depth + 1, newPath, newUsed, res);
            }
        }


    }

    //深度优先+回溯
    private static void dfs_0(int[] ints, int len, int depth, Stack<Integer> path, boolean[] used, List<List<Integer>> res) {
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

            dfs_0(ints, len, depth + 1, path, used, res);

            //回溯
            path.pop();
            used[i] = false;
        }
    }

}
