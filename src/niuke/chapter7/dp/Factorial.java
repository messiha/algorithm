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
 * 暴力递归：
 * 把问题转化成规模缩小了的同类问题的子问题
 * 有明确的不需要继续进行递归的条件
 * 有当得到了子问题结果之后的决策过程，不记录每一个子问题的解答
 * 动态规划：
 * 从暴力递归演变而来
 * 把每一个子问题的解记录下来，避免重复计算
 * 把暴力递归的过程，抽象成状态表达
 * 并且存在化简状态表达，使其更加简洁的可能
 * <p>
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
