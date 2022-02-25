package src.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author yan.zhang
 * @Date 2022/2/22 18:00
 * @Version 1.0
 */
public class Permutations {
    /**
     * https://leetcode-cn.com/problems/permutations/
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列。
     */
    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1, 2, 3});

    }

    private static List<List<Integer>> permute(int[] ints) {
        ArrayList<Integer> res = new ArrayList<>();
        process(ints, 0, res);

        return null;
    }

    private static void process(int[] ints, int i, ArrayList<Integer> res) {

    }
}
