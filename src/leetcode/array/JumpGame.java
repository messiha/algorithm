package src.leetcode.array;

/**
 * @author yan.zhang
 * @date 2022/3/12 16:23
 */
public class JumpGame {
    /**
     * 跳跃游戏
     * https://leetcode-cn.com/problems/jump-game/
     */
    public static void main(String[] args) {
//        int[] nums = new int[]{3,2,1,0,4};
        int[] nums = new int[]{0};
        System.out.println(canJump(nums));
    }

    /**
     * 贪心思路：
     * 1.尽可能到达最远位置
     * 2.如果能到达某个位置，那一定能到达它前面的所有位置。
     *
     * @param nums
     * @return
     */
    private static boolean canJump(int[] nums) {
        //可到达的最远位置
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < nums.length; i++) {
            //i为当前位置 i>max代表该位置根本无法到达
            if (i > max) {
                return false;
            }
            max = Math.max(i + nums[i],max);
        }
        return true;
    }
}
