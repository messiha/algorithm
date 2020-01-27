/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter7.dp;

/**
 * @author yan.zhang
 * @date 2020/1/27 13:59
 */

/**
 * 求n!
 */
public class Factorial {
    //方式一
    //假设已知计算流程(算法)
    private static long getFactorial1(int n) {
        long res = 1L;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    //方式二
    //假设不知计算流程，采用如何尝试思路
    //解决n!问题，子问题是解决n*(n-1)!问题
    private static long getFactorial2(int n) {
        if (n == 1) { //中止条件，当样本等于1,子问题结束
            return 1L;
        }
        return (long) n * getFactorial2(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(getFactorial1(5));
        System.out.println(getFactorial2(5));
    }
}
