package src.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yan.zhang
 * @date 2022/3/22 22:16
 */
public class ValidParenthesisString {
    /**
     * https://leetcode-cn.com/problems/valid-parenthesis-string/
     * 有效的括号字符串
     */
    public static void main(String[] args) {
        String str = "((((()(()()()*()(((((*)()*(**(())))))(())()())(((())())())))))))(((((())*)))()))(()((*()*(*)))(*)()";
        System.out.println(checkValidString(str));
    }

    /**
     * 双栈思路
     *
     * @param str
     * @return
     */
    private static boolean checkValidString(String str) {
        Deque<Integer> leftStack = new LinkedList<>();
        Deque<Integer> asteriskStack = new LinkedList<>();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) == '(') {
                leftStack.push(i);
            } else if (str.charAt(i) == '*') {
                asteriskStack.push(i);
            } else {
                //如果不是'(' 也不是 '*' 则只能是')',此时从leftStack,asteriskStack弹出栈顶元素与之匹配
                if (!leftStack.isEmpty()) {
                    leftStack.pop();
                } else if (!asteriskStack.isEmpty()) {
                    asteriskStack.pop();
                } else {
                    //如果leftStack asteriskStack都为空
                    return false;
                }
            }
        }

        //结束遍历后leftStack，asteriskStack可能仍然有数据
        while (!leftStack.isEmpty() && !asteriskStack.isEmpty()) {
            Integer leftIndex = leftStack.pop();
            Integer asteriskIndex = asteriskStack.pop();
            //leftIndex > asteriskIndex无论如何都不能组成()
            if (leftIndex > asteriskIndex) {
                return false;
            }
        }
        //最终判断左括号栈是否为空。如果左括号栈为空，则左括号全部匹配完毕，剩下的星号都可以看成空字符串
        //如果左括号栈不为空，则还有左括号无法匹配 return false;
        return leftStack.isEmpty();
    }
}
