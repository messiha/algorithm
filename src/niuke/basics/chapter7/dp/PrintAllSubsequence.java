/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter7.dp;

/**
 * @author yan.zhang
 * @date 2020/1/27 15:01
 */
public class PrintAllSubsequence {
    public static void main(String[] args) {
        String str = "abc";
        printAllSub(str.toCharArray(), 0, "");
    }

    /**
     * @param chars
     * @param i     char数组当前位置
     * @param res   上级传递给下级的字符串
     */
    private static void printAllSub(char[] chars, int i, String res) {
        if (i == chars.length) { //到达char数组中止位置
            System.out.println(res);
            return;
        }
        printAllSub(chars, i + 1, res); //不包含当前字符决策
        printAllSub(chars, i + 1, res + chars[i]); //包含当前字符决策
    }

}
