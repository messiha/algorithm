/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/4/7 22:53
 */

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class Add {
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(10));
        System.out.println(solution(5, 7));
    }


    /**
     * 思路：
     * 使用位运算
     * 十进制运算：5+7=12
     * 1.相加各位值:2
     * 2.计算进位值:10,如果进位值为0,第一步得到值即为最终结果，没有第三步
     * 3.重复执行 1，2两个子步骤，相加值为1,2步骤得到的结果即2+10，直到进位值为0
     * <p>
     * 二进制运算：
     * 0. 5-101 7-111
     * 1.相加各位 010 二进制下即为异或运算 101^111
     * 2.计算进位值: 1010 二进制下即为 与运算 并将结果左移一位 (101&111)<<1  -> 101<<1  ->1010
     * 3.重复执行
     * 1,2结果相加
     * ---各位相加 010^1010 -> 1000
     * ---进位值 (010&1010)<<1  产生的进位值为100
     * <p>
     * ---相加各位 100^1000 -> 1100
     * ---(100&1000)<<1   -> (0100&1000)<<1   -> 0000 <<1  不产生进位 流程结束 返回1100为最终结果
     */
    private static int solution(int num1, int num2) {

        while (num2 != 0) {
            //相加各位值
            int tmp = num1 ^ num2;
            //进位值
            num2 = (num1 & num2) << 1;

            num1 = tmp;
        }
        return num1;
    }

}
