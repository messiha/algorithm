/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2019/8/19 22:41
 */

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

/**
 * 用两个队列实现一个栈的功能?要求给出算法和思路!
 * 入栈：将元素进队列A
 * 出栈：判断队列A中元素的个数是否为1，如果等于1，则出队列，否则将队列A中的元素
 * 以此出队列并放入队列B，直到队列A中的元素留下一个，然后队列A出队列，再把
 * 队列B中的元素出队列以此放入队列A中。
 */
public class Solution04 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        Solution04 s4 = new Solution04();
        s4.push(1);
        s4.push(2);
        s4.push(3);


        System.out.println(s4.pop());
    }

    public void push(int node) {
        //入队：栈1为空，判断栈2是否不为空，将栈2数据倒入栈1
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        stack1.push(node);
    }

    public int pop() {
        //必须判断stack2是否为空
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
