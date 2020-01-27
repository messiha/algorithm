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
        // 从index位开始的每个字符,都尝试放在新排列的k这个位置
        for (int i = index; i < chars.length; i++) {
            swap(chars, i, index); //i从0开始，将index和index之后位置的数和i位置交换
            printAllPermutation(chars, index + 1);
            //交换回去，for循环未结束，没有确定i位置上的数，i=1到i=2之前需要复原到交换前
            swap(chars, i, index);
        }
    }

    private static void swap(char[] chars, int i, int index) {
        char tmp = chars[i];
        chars[i] = chars[index];
        chars[index] = tmp;
    }
}
