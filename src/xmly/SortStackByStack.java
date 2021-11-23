package src.xmly;

import java.util.Stack;

/**
 * @Author yan.zhang
 * @Date 2021/11/23 19:49
 * @Version 1.0
 */
public class SortStackByStack {
    /**
     * 使用一个栈结构完成另一个栈排序，自顶向下为由大到小顺序
     */
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        SortStackByStack.sort(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    private static void sort(Stack<Integer> stack) {

        Stack<Integer> help = new Stack<>();

        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
