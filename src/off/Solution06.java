/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2019/8/27 23:21
 */
public class Solution06 {
    /**
     * 输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * 斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
     * F(n)=F(n-1)+F(n-2)
     */
    public static void main(String[] args) {
        System.out.println(Fibonacci(3));
    }

    /**
     * Fibonacci(4) = Fibonacci(3) + Fibonacci(2);
     * = Fibonacci(2) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
     * = Fibonacci(1) + Fibonacci(0) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
     */
    public static int Fibonacci(int n) {
        if (n <= 1) return n;
        int pre = Fibonacci(n - 1);
        int off = Fibonacci(n - 2);
        return pre + off;
    }
}
