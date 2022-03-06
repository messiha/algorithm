package src.leetcode.trace;

import java.util.*;

/**
 * @author yan.zhang
 * @date 2022/3/4 22:34
 */
public class CombineSum {
    /**
     * https://leetcode-cn.com/problems/combination-sum/
     * 组合总和
     */
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        int ps = 0;
//        dfs(arr, 0, ps, path, res, target);
        dfs(arr, 0, path, res, target);

        print(res);

    }

    private static void print(List<List<Integer>> res) {
        for (List<Integer> item : res) {
            System.out.println(Arrays.toString(item.toArray()));
        }
    }

    /**
     * @param arr
     * @param begin   搜索起点
     * @param pathSum
     * @param path
     * @param res
     * @param target
     */
    private static void dfs(int[] arr, int begin, int pathSum, Deque<Integer> path, List<List<Integer>> res, int target) {
        if (pathSum == target) {
            res.add(new ArrayList<>(path));
            return;
        } else if (pathSum > target) {
            return;
        }
        for (int i = begin; i < arr.length; i++) {
            path.addLast(arr[i]);
            pathSum += arr[i];

            dfs(arr, i, pathSum, path, res, target);

            path.removeLast();
            pathSum -= arr[i];
        }
    }

    private static void dfs(int[] arr, int begin, Deque<Integer> path, List<List<Integer>> res, int target) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        //注意这里i=begin
        //[2,3,6,7]当用起始选择2,后续可以使用3,6,7
        //当起始选择3则不可以再次使用2,所以i=begin
        for (int i = begin; i < arr.length; i++) {
            path.addLast(arr[i]);
            dfs(arr, i, path, res, target - arr[i]);
            path.removeLast();
        }
    }


    private static void dfsBySortedArray(int[] arr, int begin, Deque<Integer> path, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < arr.length; i++) {
            //前提是数组已经排序
            //这里当选择一个数已经使得target - arr[i] < 0，后续数会更大，所以可以提前终止
            if (target - arr[i] < 0) {
                break;
            }
            path.addLast(arr[i]);
            dfs(arr, i, path, res, target - arr[i]);
            path.removeLast();
        }
    }
}
