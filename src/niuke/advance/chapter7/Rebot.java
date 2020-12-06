/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter7;

/**
 * @author yan.zhang
 * @date 2020/12/6 14:19
 */
public class Rebot {
    public static void main(String[] args) {
        System.out.println(ways1(40, 2, 21, 4));
        System.out.println(ways2(40, 2, 21, 4));
    }

    /**
     * @param N 一共有1~N的位置
     * @param M 初始停留的位置
     * @param P 可以走的步数
     * @param K 最终停留的位置
     * @return 一共有多少种走法
     */
    private static int ways1(int N, int M, int P, int K) {
        if (N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) {
            return 0;
        }

        return process(N, M, P, K);
    }

    private static int ways2(int N, int M, int P, int K) {
        if (N < 2 || M < 1 || M > N || P < 0 || K < 1 || K > N) {
            return 0;
        }

        return processByDp(N, M, P, K);
    }

    private static int process(int n, int m, int p, int k) {
        if (p == 0) {
            return m == k ? 1 : 0;
        }

        int res = 0;

        //m在1位置，只能右移
        if (m == 1) {
            res = ways1(n, m + 1, p - 1, k);
        } else if (m == n) {
            res = ways1(n, m - 1, p - 1, k);
        } else {
            res = ways1(n, m + 1, p - 1, k) + ways1(n, m - 1, p - 1, k);
        }
        return res;
    }


    /**
     * 1.可变参数M,P
     */
    private static int processByDp(int n, int m, int p, int k) {
        int[][] dp = new int[p + 1][n];
        //init
        dp[0][k - 1] = 1;
        for (int i = 1; i <= p; i++) {
            for (int j = 0; j < n; j++) {
                int left = j - 1 < 0 ? 0 : dp[i - 1][j - 1];
                int right = j + 1 >= n ? 0 : dp[i - 1][j + 1];
                dp[i][j] = left + right;
            }
        }
        return dp[p][m - 1];
    }

}
