package src.leetcode.dp;

/**
 * @author yan.zhang
 * @date 2022/4/16 16:15
 */
public class UniqueBinarySearchTree {
    /**
     * https://leetcode-cn.com/problems/unique-binary-search-trees/
     * 不同的二叉搜索树
     */
    public static void main(String[] args) {
        System.out.println(numsTrees(3));
    }

    /**
     * G(n)=G(0)∗G(n−1)+G(1)∗(n−2)+...+G(n−1)∗G(0)
     *
     * @param n
     */
    private static int numsTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        //用dp[i] 代表 i = n时的计算结果，所以这里i<n+1 保证i值能取到n。
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] = dp[i] + dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
