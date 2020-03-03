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
public class Fibonacci {
    /**
     * 输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
     * n<=39
     * 斐波那契数列：0,1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
     * F(n)=F(n-1)+F(n-2)
     */
    public static void main(String[] args) {

        System.out.println(solutionByRecur(40));
        System.out.println(solutionByDp(40));

    }

    /**
     * Fibonacci(4) = Fibonacci(3) + Fibonacci(2);
     * = Fibonacci(2) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
     * = Fibonacci(1) + Fibonacci(0) + Fibonacci(1) + Fibonacci(1) + Fibonacci(0);
     */
    public static int solutionByRecur(int n) {
        if (n <= 1) return n;
        int pre = solutionByRecur(n - 1);
        int off = solutionByRecur(n - 2);
        return pre + off;
    }

    /**
     * F(n)=F(n-1)+F(n-2)  => h = a + b
     * a = 1 b=0;
     * n=0 h=0,n=1 h=1;
     * <p>
     * n=2 => h = f(1) + f(0) => h = 1 + 0
     * n=3 => h = f(2) + f(1) => a + b + b
     * n=4 => h = f(3) + f(2) => f(2) + f(1) + f(1) + f(0) => a+b+b + a+b
     * 只要保存记录下f(n-1),f(n-2)即可一直递推出后续任何位置上的数
     */
    public static int solutionByDp(int n) {
        if (n <= 1) return n;
        int a = 1, b = 0;
        int res = 0;
        for (int i = 0; n - i - 1 > 0; i++) {
            //n > 1 即n = 2 第一次循环
            res = a + b;

            //a代表大值,b代表小值
            b = a;

            a = res;
        }
        return res;
    }
}
