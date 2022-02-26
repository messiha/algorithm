package src.leetcode.str;

/**
 * @Author yan.zhang
 * @Date 2022/2/26 15:27
 * @Version 1.0
 */
public class ReverseWords {
    /**
     * https://leetcode-cn.com/problems/reverse-words-in-a-string-iii/
     */
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(solution(str));
    }

    private static String solution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        int i = 0;
        int len = str.length();
        while (i < len) {
            //用start记录i出发点
            int start = i;
            while (i < len && chars[i] != ' ') {
                i++;
            }

            for (int p = i - 1; p >= start; p--) {
                sb.append(chars[p]);
            }
            while (i < len && chars[i] == ' ') {
                sb.append(' ');
                i++;
            }
        }
        return sb.toString();
    }
}
