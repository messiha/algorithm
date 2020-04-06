/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/4/6 15:30
 */

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 * <p>
 * 补码：正数不变，负数是它的正数的反码+1
 * ag： -2的补码，   2->0000 0010 ,   2的反码：1111 1101，再+1，即1111 1110
 */
public class NumberOfOne {
    public static void main(String[] args) {

        System.out.println();
        Integer tar = -2;
        int res = cal(tar);
        System.out.println("tar的二进制:" + Integer.toBinaryString(tar));
        System.out.println("tar的二进制位数:" + Integer.toBinaryString(tar).length());
        System.out.println(res);
    }

    private static int cal(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
