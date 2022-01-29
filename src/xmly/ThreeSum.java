package src.xmly;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author yan.zhang
 * @Date 2021/11/25 14:40
 * @Version 1.0
 */
public class ThreeSum {
    /**
     * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
     * 答案中不可以包含重复的三元组。
     * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     * 满足要求的三元组集合为：
     * [
     * [-1, 0, 1],
     * [-1, -1, 2]
     * ]
     */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution(nums);
        System.out.println(result);
    }

    private static List<List<Integer>> solution(int[] nums) {
        //[-4,-1,-1,0,1,2]
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                //结果为0，且不能为[0,0,0]则一定有正数有负数
                break;
            }

            //当前位置和前一个位置数值相同，则会出现已经被"查找"过的情况，所以需要忽略。
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1;
            int r = nums.length - 1;

            int target = -nums[i];
            while (l < r) {
                if (nums[l] + nums[r] == target) {
                    ArrayList<Integer> stash = new ArrayList<>();
                    stash.add(nums[i]);
                    stash.add(nums[l]);
                    stash.add(nums[r]);
                    result.add(stash);

                    //不可以包含重复的三元组
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (nums[l] + nums[r] > target) {
                    //如果相加值大于target则需要将相加结果"调小"，所以将r指针左移动
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }

}
