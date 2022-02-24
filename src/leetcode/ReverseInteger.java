package src.leetcode;

/**
 * @Author yan.zhang
 * @Date 2022/2/24 14:02
 * @Version 1.0
 */
public class ReverseInteger {
    /**
     * https://leetcode-cn.com/problems/reverse-integer/
     * 整数反转
     */
    public static void main(String[] args) {
        int num = 123;
        System.out.println(solution(num));
    }

    private static int solution(int num) {
        int rev = 0;

        while (num != 0) {
            //检查是否超过边界
            if (rev > Integer.MAX_VALUE / 10 || rev < Integer.MIN_VALUE / 10) {
                return 0;
            }
            int digit = num % 10;
            num = num / 10;
            rev = rev * 10 + digit;
        }

        return rev;
    }
}
