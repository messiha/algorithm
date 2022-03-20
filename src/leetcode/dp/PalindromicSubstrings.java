package src.leetcode.dp;

/**
 * @author yan.zhang
 * @date 2022/3/20 12:12
 */
public class PalindromicSubstrings {
    /**
     * 回文子串
     * https://leetcode-cn.com/problems/palindromic-substrings/
     */
    public static void main(String[] args) {
        String str = "aaaaa";
        System.out.println(countSubstrings_01(str));
    }

    private static int countSubstrings(String str) {
        int ans = 0;
        char[] chars = str.toCharArray();
        int len = chars.length;
        boolean[][] dp = new boolean[len][len];

        //init dp[][]
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
            ans++;
        }

        //j = 1,i = 0 "填表"只需要填充j>i的部分，即对角线一半,i<j则对角线不需要判断。在init dp[][]时已经初始化，所以也需要ans++
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }


    /**
     * 尝试向两端扩展的方式
     * 1.回文中心为单字符
     * 2.回文中心为双字符
     * 解释
     * https://leetcode-cn.com/problems/palindromic-substrings/solution/liang-dao-hui-wen-zi-chuan-de-jie-fa-xiang-jie-zho/
     */
    static int ans = 0;

    private static int countSubstrings_01(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            //回文串长度为奇数
            count(chars, i, i);
            //回文串长度为偶数
            count(chars, i, i + 1);
        }
        return ans;
    }

    private static void count(char[] chars, int start, int end) {
        int length = chars.length;
        while (start >= 0 && end < length && chars[start] == chars[end]) {
            ans++;
            start--;
            end++;
        }
    }

}
