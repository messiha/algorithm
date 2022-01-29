/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter7.dp;

/**
 * @author yan.zhang
 * @date 2020/1/27 17:40
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 打印字符串全排列
 */
public class PrintAllPermutation {

    public static void main(String[] args) {
        String str = "aaa";
        printAllPermutation(str.toCharArray(), 0);
        List<String> res = new ArrayList<>();
        process(str.toCharArray(), 0, res);

        //[aaa]
        System.out.println(res);
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
            //恢复现场，才能正确执行。
            swap(chars, i, index);
        }
    }

    private static void swap(char[] chars, int i, int index) {
        char tmp = chars[i];
        chars[i] = chars[index];
        chars[index] = tmp;
    }

    //要求在打印全排列过程中，过滤重复的组合
    //递归+分支限界
    //分支限界：递归展开过程中，提前否定之路
    private static void process(char[] str, int i, List<String> res) {
        if (i == str.length) {
            res.add(String.valueOf(str));
            return;
        }

        //这里是26个字母，声明一个数组
        //如果不是字母，可以使用hashSet代替
        //visit[0] 代表a字符是否被使用过
        boolean[] visit = new boolean[26];

        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                process(str, i + 1, res);
                swap(str, i, j);
            }
        }
    }
}
