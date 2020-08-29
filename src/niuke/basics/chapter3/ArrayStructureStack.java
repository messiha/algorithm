/*
 * All rights Reserved, Designed By baowei
 *
 * 注意：本内容仅限于内部传阅，禁止外泄以及用于其他的商业目的
 */
package src.niuke.basics.chapter3;

/**
 * @author yan.zhang
 * @date 2019/10/7 18:12
 */

/**
 * 用数组结构实现大小固定的队列和栈
 */
public class ArrayStructureStack {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.push(1);
        arrayQueue.push(2);
        arrayQueue.push(3);
//        System.out.println(arrayQueue.poll());
//        System.out.println(arrayQueue.poll());
//        System.out.println(arrayQueue.poll());
    }


    static class ArrayStack {
        private Integer arr[];
        /**
         * 栈指针，初始指向0
         */
        private Integer index;

        public ArrayStack(Integer initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("the init size is less than 0!");
            }
            arr = new Integer[initSize];
            index = 0;
        }

        /**
         * 返回栈顶，不删除栈顶的值
         *
         * @return
         */
        public Integer peek() {
            if (index == 0) {
                return null;
            }
            return arr[index - 1];
        }


        public void push(int obj) {
            if (index == arr.length) {
                throw new IllegalArgumentException("the stack is full!");
            }
            arr[index++] = obj;
        }


        public Integer pop() {
            if (index == 0) {
                throw new IllegalArgumentException("the stack is full!");
            }
            return arr[--index];
        }
    }

    /**
     * 数组实现的 循环队列
     */
    static class ArrayQueue {
        private Integer arr[];
        /**
         * 弹出位置下标
         */
        private Integer start;
        /**
         * 加入位置下标
         */
        private Integer end;
        /**
         * 检查队列大小是否越界
         */
        private Integer size;

        public ArrayQueue(int initSize) {
            if (initSize < 0) {
                throw new IllegalArgumentException("the init size is less than 0!");
            }
            arr = new Integer[initSize];
            size = 0;
            start = 0;
            end = 0;
        }


        public Integer peek() {
            if (size == 0) {
                return null;
            }
            return arr[start];
        }

        /**
         * 弹出队列顶端，并删除
         */
        public Integer poll() {
            if (size == 0) {
                throw new ArrayIndexOutOfBoundsException("the queue is empty!");
            }
            size--;
            int tmp = start;
            start = start == arr.length - 1 ? 0 : start + 1;
            return arr[tmp];
        }

        public void push(int obj) {
            if (size == arr.length) {
                throw new IllegalArgumentException("the queue is full!");
            }
            size++;
            arr[end] = obj;
            //arr[end] = obj;end = end == arr.length - 1 ? 0 : end ++;  end++错误
            end = end == arr.length - 1 ? 0 : end + 1;
        }
    }

}

