package src.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
        String str = "abba";
        System.out.println(lengthOfLongestSubstring2(str));
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

    public static int lengthOfLongestSubstring2(String s) {
        if (s.length() <=1) return s.length();
        int max = 0;
        int left = 0;
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //"abba" Math.max()遇到后面重复出现的字符，防止窗口下标被重置
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
