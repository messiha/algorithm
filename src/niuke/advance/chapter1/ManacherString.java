/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.advance.chapter1;

/**
 * @author yan.zhang
 * @date 2020/1/30 11:22
 */

/**
 * 回文半径数组
 * 回文右边界 / 回文右边界中心
 */
public class ManacherString {


    public static void main(String[] args) {
        System.out.println(3 & 1);
        System.out.println(3 % 1);
        String str = "abccba";
        maxLcpsLength(str);
    }

    private static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //预处理字符串
        char[] pArr = manacherString(str);
        return -1;
    }

    private static char[] manacherString(String str) {
        char[] chars = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];

        int index = 0;
        for (int i = 0; i < res.length; i++) {
            //i & 1 等同于 i % 2
            res[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return res;
    }
}
