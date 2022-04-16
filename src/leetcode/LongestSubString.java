package src.leetcode;

import java.util.HashSet;

/**
 * @author yan.zhang
 * @date 2022/4/16 22:55
 */
public class LongestSubString {
    /**
     * 无重复字符串的最长子串长度
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     */
    public static void main(String[] args) {
        String str = "abccbda";
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * 利用滑动窗口思想
     * 用Set集合记录出现过的字符
     *
     * @param str
     * @return
     */
    private static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int len = str.length();
        char[] chars = str.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        int r = -1;
        for (int i = 0; i < chars.length; i++) {
            if (i > 0) {
                set.remove(chars[i - 1]);
            }
            //r指针向右侧移动
            while (r + 1 < len && !set.contains(chars[r + 1])) {
                set.add(chars[r + 1]);
                r++;
            }
            ans = Math.max(ans, r - i + 1);
        }
        return ans;
    }
}
