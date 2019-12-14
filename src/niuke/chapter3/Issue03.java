/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.chapter3;

/**
 * @author yan.zhang
 * @date 2019/10/7 19:58
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 题目一：实现一个特殊的栈，在实现栈的基本功能基础上，增加返回栈中最小元素的操作
 * 要求：1）pop,push,getMin操作最小时间复杂度都是O(1)
 *      2）设计栈类型可以使用线程的栈结构
 * <p>
 * 思路一：设计两个栈 一个正常栈，一个最小栈
 * push操作中如果栈为空 正常栈和最小栈直接压入
 * 如果不为空 比较入值和最小栈栈顶大小，如果小于最小栈栈顶 压入，如果大于则重复压入最小栈栈顶数值
 */
public class Issue03 {

    public static void main(String[] args) {
        TwoStackQueue twoStackQueue = new TwoStackQueue();
        twoStackQueue.push(1);
        twoStackQueue.push(2);
        twoStackQueue.push(3);
        twoStackQueue.push(4);

        System.out.println(twoStackQueue.pop());
        System.out.println(twoStackQueue.pop());
        System.out.println(twoStackQueue.pop());
    }

    static class MyStack01 {
        private Stack<Integer> stackData;
        private Stack<Integer> stackMin;  //最小栈

        public MyStack01() {
            this.stackData = new Stack<>();
            this.stackMin = new Stack<>();
        }

        public void push(int newNum) {
            if (stackMin.isEmpty()) {
                stackMin.push(newNum);
            } else if (newNum < this.getMin()) {
                stackMin.push(newNum);
            } else {
                Integer newMin = stackMin.peek();
                stackMin.push(newMin);
            }
            stackData.push(newNum);
        }

        private int getMin() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is empty!");
            }
            return stackMin.peek();
        }

        public Integer pop() {
            if (stackData.isEmpty()) {
                throw new RuntimeException("stack is empty!");
            }
            stackMin.pop();
            return stackData.pop();
        }
    }


    /**
     * 仅用队列结构实现栈结构
     */
    static class TwoQueueStack {
        private Queue<Integer> data;
        private Queue<Integer> help;

        public TwoQueueStack() {
            data = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int newNum) {
            data.add(newNum);
        }

        public Integer pop() {
            if (data.isEmpty()) {
                throw new RuntimeException("stack is empty!");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            //将help——>data 队列
            swap();
            return res;
        }

        private void swap() {
            Queue tmp = help;
            help = data;
            data = tmp;
        }

        public Integer peek() {
            if (data.isEmpty()) {
                throw new RuntimeException("stack is empty!");
            }
            while (data.size() != 1) {
                help.add(data.poll());
            }
            int res = data.poll();
            help.add(res);
            swap();
            return res;
        }
    }


    /**
     * 如何仅用栈结构实现队列
     * 原则1：push 向 pop中倒数据 必须全部倒完
     * 原则2：pop栈中有数据，push栈不能像pop栈中倒数据
     */
    static class TwoStackQueue {
        private Stack<Integer> stackPush;
        private Stack<Integer> stackPop;

        public TwoStackQueue() {
            stackPush = new Stack<>();
            stackPop = new Stack<>();
        }

        public void push(int newNum) {
            stackPush.add(newNum);
            transferData();
        }

        public Integer peek() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            transferData();
            return stackPop.peek();
        }

        public Integer pop() {
            if (stackPush.empty() && stackPop.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            transferData();
            return stackPop.pop();
        }

        /**
         * stackPush向stackPop转移数据过程
         */
        public void transferData() {
            if (!stackPop.empty()) {
                return;
            }
            //stackPop不为空，一次性倒完
            while (!stackPush.empty()) {
                stackPop.push(stackPush.pop());
            }
        }

    }

}




