/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter1;

/**
 * @author yan.zhang
 * @date 2020/1/28 18:04
 */

/**
 * 概念：在一个字符串中，某个字符之前的字符串最长前缀和最长后缀匹配长度(前缀不能包含最后一个字符，后缀不能包含最前一个字符)
 * 举例: abcabcd,对于d最长前缀和最长后缀的匹配为 abc = abc  所以对于d最大前缀/后缀匹配长度为3，
 * 若匹配长度为1,a != c
 * 匹配长度为2,ab != bc
 * .
 * .
 * .
 * 前缀后缀都取4 不相等 ..采用这种思路
 * <p>
 * 若求str1是否包含str2
 */
public class KMP {

    /**
     * 暴力查找
     */
    private static int search_01(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        for (int i = 0; i < N - M; i++) {
            int j;
            for (j = 0; j < M; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == M) return i; //找到匹配
        }
        return N;//未找到匹配
    }

    private static int search_02(String pat, String txt) {
        int i, N = txt.length();
        int j, M = pat.length();
        for (i = 0, j = 0; i < N && j < M; i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
        }
        if (j == M) return i - M;
        else return N;

    }

    public static void main(String[] args) {
        String txt = "ABACADABRAC";
        String pat = "ABRA";
        System.out.println(search_01(pat, txt));
        System.out.println(search_02(pat, txt));
    }
}
