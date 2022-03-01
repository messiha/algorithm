package src.xmly;

/**
 * @Author yan.zhang
 * @Date 2021/12/18 15:33
 * @Version 1.0
 */
public class LongestPalindrome {
    /**
     * 给你一个字符串 s，找到 s 中最长的回文子串。
     * 1.s = "babad"  =>  "bab"或者"aba"
     * 2.s = "cbbd"   => "bb"
     * 3.s = "a"      => "a"
     */
    public static void main(String[] args) {
        System.out.println(isLongestPalindrome("aabaa"));
//      System.out.println(isLongestPalindrome("cbbd"));
    }

    /**
     * 暴力解法
     */
    private static String isLongestPalindromeByBasic(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int begin = 0, maxLen = 1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j-i+1>maxLen && isValid(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        return s.substring(begin, maxLen);
    }

    private static boolean isValid(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


    /**
     * 动态规划法
     * 一旦一个回文串的两端，对称的加上相同的元素，那么新形成的字符串仍然是一个回文串。
     * 推论：
     * 1）字符串两边字符不相等，一定不是回文。
     * 2）如果两边字符相等，则检查去掉两段字符串后的子串是否为回文串。
     * <p>
     * dp：从一个比较小规模的问题开始，逐步得到较大规模问题的解的过程，需要记录每一步的结果，较大规模问题需要参考上一步结果。
     */
    private static String isLongestPalindrome(String s) {
        int len = s.length();
        if (len == 0) {
            return s;
        }
        //dp[i][j] 用来记录s[i,j]是否为回文子串
        //根据推论得出 dp[i][j] = (s[i] == s[j]) and dp[i+1][j-1]  表示：在s[i] == s[j]的前提下，dp[i+1][j-1]的结果代表了dp[i][j]的回文性质
        //边界条件: j - 1 - (i+1) + 1 < 2 整理得 j - i < 3
        //初始化dp[i][j] = true 单个字符串一定是回文串
        //输出：在得到一个状态值为true时，记录起始位置和长度，填表完成再取。
        int begin = 0;
        int maxLen = 1;

        boolean[][] dp = new boolean[len][len];

        //初始化表格
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();

        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                //头尾不相等
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    //头尾相等，检查将头尾去掉情况
                    if (j - i < 3) {
                        //j - 1 - (i+1) + 1 < 2 不构成区间的前提下，仍为回文串
                        dp[i][j] = true;
                    } else {
                        //参考更小规模问题的结果
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //只要dp[i][j] = true 就标识s[i,j] dp为回文串，此时比较长度并记录
                if (dp[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }


}
