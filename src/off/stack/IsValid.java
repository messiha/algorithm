package src.off.stack;

import java.util.Stack;

/**
 * @author yan.zhang
 * @date 2020/12/22 15:39
 */
public class IsValid {
    /**
     * 给出一个仅包含字符'(',')','{','}','['和']',的字符串，判断给出的字符串是否是合法的括号序列
     * 括号必须以正确的顺序关闭，"()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
     * 输入："[" return false
     *
     * @param args
     */
    public static void main(String[] args) {
//        String str = "{[]}";
        String str = "}";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            //第一次栈空
            if (stack.empty()) {
                stack.push(aChar);
                continue;
            }
            //当前char为 ) ] }  &&  ) ] } 开始弹栈
            if (')' == aChar && stack.peek().equals('(')) {
                stack.pop();
            } else if (']' == aChar && stack.peek().equals('[')) {
                stack.pop();
            } else if ('}' == aChar && stack.peek().equals('{')) {
                stack.pop();
            } else {
                //如果不是) ] } 则继续压入
                stack.push(aChar);
            }

        }

        return stack.isEmpty();
    }
}
