package src.leetcode.str;

/**
 * @Author yan.zhang
 * @Date 2022/2/26 14:58
 * @Version 1.0
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        solution(str);
    }

    private static boolean solution(String str) {
        StringBuilder sb = new StringBuilder();
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (Character.isLetterOrDigit(aChar)) {
                sb.append(Character.toLowerCase(aChar));
            }
        }
        StringBuilder reverse = new StringBuilder(sb).reverse();
        return reverse.toString().equals(sb.toString());
    }

}
