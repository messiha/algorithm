package src.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yan.zhang
 * @date 2022/2/27 14:55
 */
public class FindFirstAndLastPositionInSortArray {
    /**
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * 在排序数组中查找元素第一个和最后一个位置
     */
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(solutionByBS(nums, target)));
    }

    /**
     * 二分查找思路
     *
     * @param nums
     * @param target
     * @return
     */
    private static int[] solutionByBS(int[] nums, int target) {
        int index = binarySearch(nums, target);

        if (index == -1) {
            return new int[]{-1, -1};
        }
        int left = index, right = index;
        while (left - 1 >= 0 && nums[left - 1] == target) {
            left--;
        }
        while (right + 1 < nums.length && nums[right + 1] == target) {
            right++;
        }
        return new int[]{left, right};

    }

    /**
     * @param nums
     * @param target
     * @return
     */
    private static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    private static int[] solution(int[] nums, int target) {
        List<Integer> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            result.add(-1);
            result.add(-1);
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }

        for (int i = 0, start = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
                start = i;
                while (start < nums.length && nums[start] == target) {
                    start++;
                }
                result.add(start - 1);
                break;
            }
        }

        if (result.size() == 0) {
            result.add(-1);
            result.add(-1);
            return result.stream().mapToInt(Integer::valueOf).toArray();
        }


        return result.stream().mapToInt(Integer::valueOf).toArray();
    }
}
