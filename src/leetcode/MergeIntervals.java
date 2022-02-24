package src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author yan.zhang
 * @Date 2022/2/22 15:36
 * @Version 1.0
 */
public class MergeIntervals {
    /**
     * https://leetcode-cn.com/problems/merge-intervals/
     */
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 4}, {0, 2}, {3, 5}};
//        int[][] intervals = {{1, 3}};
//        int[][] intervals = {{1, 4}, {0, 0}};
        int[][] result = merge(intervals);
        print(result);
    }

    private static void print(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 1) {
            return null;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];

            //如果为空直接将第一个放入
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                //其余情况，需要合并，比较i和i-1数组，第二个值大小
                int[] preInts = merged.get(merged.size() - 1);
                int max = Math.max(R, preInts[1]);
                preInts[1] = max;
            }

        }

        return merged.toArray(new int[0][0]);
    }
}
