package src.exercise;

import java.util.LinkedList;
import java.util.Queue;

public class Practice4 {
    Queue<Integer> data;
    Queue<Integer> help;

    public Practice4() {
        this.data = new LinkedList<>();
        this.help = new LinkedList<>();
    }

    private void push(int node) {
        data.add(node);
    }

    private int pop() {
        if (data.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        return res;
    }

    private int peek() {
        if (data.isEmpty()) {
            throw new RuntimeException("stack is empty!");
        }
        while (data.size() != 1) {
            help.add(data.poll());
        }
        int res = data.poll();
        swap();
        data.add(res);
        return res;
    }

    private void swap() {
        Queue<Integer> tmp = data;
        data = help;
        help = tmp;
    }

    public static void main(String[] args) {
        Practice4 s4 = new Practice4();
        s4.push(1);
        s4.push(2);
        s4.push(3);
        System.out.println(s4.peek());
        System.out.println(s4.peek());
        s4.push(4);
        System.out.println(s4.pop());
        System.out.println(s4.pop());
    }


}
