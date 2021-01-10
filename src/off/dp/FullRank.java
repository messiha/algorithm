/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off.dp;

import java.util.Stack;

/**
 * @author yan.zhang
 * @date 2021/1/9 21:03
 */
public class FullRank {
    /**
     * 給出ABC三个字母。输出全排列。要求第一个字母如果是A,第二个字母可选择只有BC
     */
    public static void main(String[] args) {
        char[] chars = new char[]{'a', 'b', 'c', 'd'};
        export(chars);
    }

    /**
     * DP问题
     *
     * @param chars
     */
    private static void export(char[] chars) {
        //used代表，used数组中i下标对应的char是否被使用过
        boolean[] used = new boolean[chars.length];

//        dfs(chars, used, 0, new Stack<>());
        dfs(chars);
    }


    private static void dfs(char[] chars, boolean[] used, int level, Stack<Character> res) {
        if (level == chars.length) {
            System.out.println(res.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {

            if (!used[i]) {
                //节点没有被使用
                res.add(chars[i]);
                used[i] = true;
                //在下一层找可用节点
                dfs(chars, used, level + 1, res);
                used[i] = false;
                //使用树结构辅助理解
                //使用栈结构，将第三层和第二层字母弹出，需要保留第一层数据
                res.pop();
            }

        }
    }

    /**
     * 优化改进dfs方法签名
     */
    private static final Stack<Character> STACK = new Stack<>();

    private static void dfs(char[] chars) {
        if (STACK.size() == chars.length) {
            System.out.println(STACK.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                char c = chars[i];
                STACK.add(c);
                chars[i] = ' ';
                dfs(chars);
                chars[i] = c;
                STACK.pop();
            }
        }
    }

}
