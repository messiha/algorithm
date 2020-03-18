/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.off;

/**
 * @author yan.zhang
 * @date 2020/3/18 21:52
 */

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O(1))
 * 注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */
public class ContainMainStack {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else if (minStack.peek() > node) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        minStack.pop();
        dataStack.pop();
    }

    public int top() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        return dataStack.peek();
    }

    public int min() {
        if (dataStack.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        return minStack.peek();
    }
}
