/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter7.dp;

/**
 * @author yan.zhang
 * @date 2020/1/27 17:40
 */

/**
 * 打印字符串全排列
 */
public class PrintAllPermutation {

    public static void main(String[] args) {
        String str = "abc";
        printAllPermutation(str.toCharArray(), 0);
    }

    private static void printAllPermutation(char[] chars, int index) {
        if (index == chars.length) {
            System.out.println(chars);
        }
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index);
            printAllPermutation(chars, index + 1);
            swap(chars, i, index);
        }
    }

    private static void swap(char[] chars, int i, int index) {
        char tmp = chars[i];
        chars[i] = chars[index];
        chars[index] = tmp;
    }
}
