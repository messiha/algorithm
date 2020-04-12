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
 * 回文半径数组:从左向右求每一个字符的回文半径保存在回文半径数据中
 * 回文右边界 / 回文右边界中心
 * <p>
 * 当前下标i
 * 1.i在回文右边界外
 * 2.i在回文有边界内（此时有三种可能）
 */
public class ManacherString {


    public static void main(String[] args) {
        System.out.println(3 & 1);
        System.out.println(3 % 1);
        String str = "abccba";
        System.out.println(maxLcpsLength(str));
    }

    private static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        //预处理字符串
        char[] charArr = manacherString(str);

        //回文半径数组
        int[] pArr = new int[charArr.length];
        //回文半径中心
        int C = -1;
        //回文右边界
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            //2 * C - i i位置关于C的对称点坐标
            //R > i 代表i在回文右边界内 R < i尝试扩一次
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;

            //i回文半径左右均不越界
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    //回文半径增加
                    pArr[i]++;
                } else {
                    break;
                }
            }
            //i位置回文半径在R外，暴力尝试
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
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

    /**
     * 扩展：给定一个字符串，只能在该字符串后添加字符，添加最短的字符，使整体成为回文字符串
     * ag：abc12321  ->添加 cba
     * 思路：求 必须包含最后一个字符串最长回文串长度，将不是回文部分逆序，即最后结果
     * 改写manacher算法，最右回文又边界到字符最后一个位置停止
     */
}
