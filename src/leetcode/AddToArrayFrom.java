package src.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author yan.zhang
 * @Date 2022/2/23 14:24
 * @Version 1.0
 */
public class AddToArrayFrom {
    /**
     * https://leetcode-cn.com/problems/add-to-array-form-of-integer/
     * 数组形式的整数加法
     */
    public static void main(String[] args) {
       /* int[] nums = new int[]{1, 2, 0, 6};
        int k = 34;*/
       /* int[] nums = new int[]{2, 1, 5};
        int k = 806;*/
        int[] nums = new int[]{6};
        int k = 809;
        List<Integer> solution = solution(nums, k);
        System.out.println(solution.toString());
    }

    private static List<Integer> solution(int[] num, int k) {
        LinkedList<Integer> res = new LinkedList<>();
        int carry = 0;
        int tail = num.length - 1;
        int lastK = 0;
        while (tail >= 0 || k != 0) {
            lastK = k == 0 ? 0 : k % 10;
            int tailNum = tail < 0 ? 0 : num[tail--];

            int sum = tailNum + lastK + carry;
            carry = sum / 10;
            k = k / 10;
            res.addFirst(sum % 10);
        }

        //处理特殊情况：数组第一位+k第一位 超过10需要进位的情况
        if (carry != 0) {
            res.addFirst(carry);
        }
        return res;
    }
}
