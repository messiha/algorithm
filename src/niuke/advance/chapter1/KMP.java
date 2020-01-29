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

    /**
     * KMP
     */
    private static int getIndexOf(String txt, String pat) {
        if (txt == null || pat == null || txt.length() < 1 || pat.length() < 1) {
            return -1;
        }
        char[] str1 = txt.toCharArray();
        char[] str2 = pat.toCharArray();
        int i1 = 0;
        int i2 = 0;
        int[] nextArray = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else {
                if (nextArray[i2] == -1) { //nextArray数组标注当前位置偏移信息
                    //-1代表 str2数组的0位置 即str1和str2第一个位置就不匹配
                    i1++;
                } else {
                    i2 = nextArray[i2];
                }
            }
        }
        //i1 == str1.length或i2 == str2.length 循环中止,检查i2下标
        return i2 == str2.length ? i1 - i2 : -1;
    }

    /**
     * 和str2数组长度一致且下标对应，代表当前字符前部分字符的最长前缀和最长后缀信息
     * str 0位置前无字符串用人为规定-1
     * str 1位置前只有一个字符,人为规定0代替(前提:前缀不能包含最后一个字符，后缀不能包含最前一个字符)
     */
    private static int[] getNextArray(char[] str) {
        if (str.length == 1) return new int[]{-1};
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;//跳转位置 (最长前缀的后一位),代表最长前缀长度
        while (i < next.length) {
            if (str[i - 1] == str[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) { //cn位置和i-1位置不相等
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }


    /**
     * 扩展问题：
     * 给定原始串,只能在原始串后添加新字符，要求生成的新串必须包含两份原始串,并且要求新串最短
     * ag: abcabc 调用函数后 abcabcabc
     *
     * 思路：求abcabc后一个位置的最大前缀和最大后缀
     */


    /**
     * 树A和树B,判断A中是否存在某一子树,使得A中的子树和B结构和数据完全一致
     * 思路：A和B序列化成字符串
     */

    /**
     * 判断某一字符串是否符合str = str_sub * N这种形式
     * ag:123123123123   =  123 * 4
     * 转换成求最长前缀和最长后缀问题
     */


    /**
     * 回文半径数组
     * 回文右边界 / 回文右边界中心
     *
     * @param args
     */
    public static void main(String[] args) {
        String txt = "ABACADABRAC";
        String pat = "ABRA";
        System.out.println(search_01(pat, txt));
        System.out.println(search_02(pat, txt));
        System.out.println(getIndexOf(txt, pat));
    }
}
