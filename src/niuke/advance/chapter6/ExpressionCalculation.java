package src.niuke.advance.chapter6;


/**
 * 给定一个字符串str，str表示一个公式，公式里可能有正数，加减乘除符号和左右括号，返回公式的计算结果
 * 举例：str = "3+1*4" = 7
 * 说明：
 * 1.可以认定给定的字符串一定是正确的公式
 * 2.如果是负数，需要用括号括起来，比如"4*(-3)",但是如果负数作为公式的开头，或者括号的开头，则可以没有括号，比如 -3*4 和(-3*4)都是合法
 * 3.不考虑计算中可能出现的溢出情况
 */

import java.util.LinkedList;

/**
 * @author yan.zhang
 * @date 2020/9/12 16:35
 */
public class ExpressionCalculation {
    /**
     * 考虑无括号情况。
     * 设计递归函数
     */
    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(calExpression(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(calExpression(exp));

        exp = "10-5*3";
        System.out.println(calExpression(exp));

        exp = "-3*4";
        System.out.println(calExpression(exp));

        exp = "3+1*4";
        System.out.println(calExpression(exp));
    }

    private static int calExpression(String str) {
        return value(str.toCharArray(), 0)[0];
    }

    /**
     * @param charArray 带计算字符串数组
     * @param i         开始计算位置
     * @return 长度为2的数组，返回数组0位置代表计算结果，1位置代表计算位置
     */
    private static int[] value(char[] charArray, int i) {
        LinkedList<String> que = new LinkedList<>();
        //记录遍历过程中数组，ag："310" pre变量会记录310
        int pre = 0;
        int[] bra = null;
        while (i < charArray.length && charArray[i] != ')') {
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                //charArray[i]为数字字符，charArray[i]的ASSIC码减去'0'的ASSIC码表示数值 ag：'9'的ASSIC码比'0'的ASSIC码大9，则结果为9
                pre = pre * 10 + charArray[i++] - '0';
            } else if (charArray[i] != '(') {
                //当前字符为 运算符，遇到字符串代表pre已经被赋值为数字
                addNum(que, pre);
                que.addLast(String.valueOf(charArray[i++]));
                pre = 0;
            } else {
                //当前字符串为'(',调用子过程
                bra = value(charArray, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, pre);
        return new int[]{getNum(que), i};
    }

    /**
     * 向queue中加入数字和运算符
     *
     * @param que
     * @param num
     */
    private static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            String top = que.pollLast();
            int cur = 0;
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? cur * num : cur / num;
            }
        }
        que.add(String.valueOf(num));
    }

    /**
     * @param que
     * @return
     */
    private static int getNum(LinkedList<String> que) {
        //ag：3-2
        int res = 0;
        boolean add = true;
        int num = 0;
        while (!que.isEmpty()) {
            String cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }


}
