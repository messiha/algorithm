/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.leetcode;

/**
 * @author yan.zhang
 * @date 2020/11/8 20:25
 */

/**
 * 给定一个数，求大于该数的最小2的n次幂，返回n。
 */
public class LeastPowerOfTwo {
    public static void main(String[] args) {
        int n = 9;
        solution(n);
    }

    private static boolean solution(int n) {
        if (n < 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
}
