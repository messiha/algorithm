package src.leetcode.str;


/**
 * @author yan.zhang
 * @date 2022/3/5 18:21
 */
public class ReverseString2 {
    /**
     * https://leetcode-cn.com/problems/reverse-string-ii/
     * 反转字符串
     */
    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(reverseStr(str, 2));
    }

    private static java.lang.String reverseStr(String str, int k) {
        char[] charArray = str.toCharArray();
        int len = str.length();

        for (int i = 0; i < len; i += 2 * k) {
            reverse(charArray, i, Math.min(i + k, len) - 1);
        }

        return new String(charArray);
    }

    private static void reverse(char[] charArray, int start, int end) {
        while (start < end) {
            char tmp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = tmp;
            end--;
            start++;
        }

    }

}
