package src.leetcode.trace;

import java.util.*;

/**
 * @author yan.zhang
 * @date 2022/4/23 15:48
 */
public class PalindromePartition {
    /**
     * 分割回文串
     * https://leetcode-cn.com/problems/palindrome-partitioning/
     */
    public static void main(String[] args) {
        String str = "aab";
        partition_dp(str);
    }

    /**
     * 回溯法思路
     *
     * @param str
     * @return
     */
    private static List<List<String>> partition(String str) {
        List<List<String>> ans = new ArrayList<>();
        int len = str.length();
        if (len == 0) {
            return ans;
        }
        Deque<String> stack = new LinkedList<>();
        dfs(str.toCharArray(), 0, len, stack, ans);
        return ans;
    }

    /**
     * @param charArray
     * @param index     起始字符串索引
     * @param len
     * @param path
     * @param ans
     */
    private static void dfs(char[] charArray, int index, int len, Deque<String> path, List<List<String>> ans) {
        if (index == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            //题目要求要求使得所有子串均为回文串。如果当前不是回文串，不产生分支
            if (!isPalindrome(charArray, index, i)) {
                continue;
            }
            path.addLast(new String(charArray, index, i - index + 1));
            //这里是i+1而不是index+1,是基于当前选择去下一个位置。保证不重复
            //当i = 1,aa|b，切分出{aa,b}时，下一次只能从b开始
            dfs(charArray, i + 1, len, path, ans);
            path.removeLast();
        }
    }

    private static boolean isPalindrome(char[] charArray, int left, int right) {
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
     * 结合动态规划，优化复杂度
     * 转移方程：s[i] == s[j] 参考 s[i+1] s[j-1]
     * dp[i][j] 用来记录s[i,j]是否为回文子串
     */
    private static List<List<String>> partition_dp(String str) {
        List<List<String>> ans = new ArrayList<>();
        int len = str.length();
        if (len == 0) {
            return ans;
        }
        char[] chars = str.toCharArray();
        Deque<String> path = new ArrayDeque<>();
        boolean[][] dp = new boolean[len][len];
        //init
        for (int right = 0; right < len; right++) {
            for (int left = 0; left <= right; left++) {
                //right-1 -(left + 1) < 1 代表单个字符，一定是回文串
                if (chars[left] == chars[right] && (right - left < 3 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        dfs(str, len, 0, dp, path, ans);
        return ans;
    }

    private static void dfs(String str, int len, int start, boolean[][] dp, Deque<String> path, List<List<String>> ans) {
        if (start == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < len; i++) {
            if (dp[start][i]) {
                //如果当前分支能产生回文子串，说明分支正确
                path.addLast(str.substring(start, i + 1));
                dfs(str, len, i + 1, dp, path, ans);
                path.removeLast();
            }
        }
    }
}
