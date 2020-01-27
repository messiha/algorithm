/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter7.dp;

/**
 * @author yan.zhang
 * @date 2020/1/27 19:14
 */

/**
 * 母牛每年生一支母牛，新出生的母牛成长三年后也能每年生一只母牛，假设牛不会死，求N年后，母牛的数量
 * f(N) = f(N-1) + f(N-3)
 * 第N年牛的数量 = 第N-1年牛的数量 + 第N-3年牛的数量
 */
public class CowNumber {

    public static void main(String[] args) {
        System.out.println(calCowNumber(6));
    }

    private static int calCowNumber(int N) {
        if (N == 1 || N == 2 || N == 3) {
            return N;
        }
        return calCowNumber(N - 1) + calCowNumber(N - 3);
    }
}
