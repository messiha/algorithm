package src.niuke.basics.chapter3;

/**
 * @author yan.zhang
 * @date 2020/8/23 11:47
 */
public class CircularQueue {
    private String[] items;
    private int size;
    private int head;
    private int tail;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        this.size = 0;
        this.head = 0;
        this.tail = 0;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(3);
        circularQueue.enqueue("a");
        circularQueue.enqueue("b");
        circularQueue.enqueue("c");
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
        System.out.println(circularQueue.dequeue());
    }


    //入队
    private void enqueue(String item) {
        if (size == items.length) {
            throw new IllegalArgumentException("queue is full!");
        }
        size++;
        items[tail] = item;
        tail = tail == items.length - 1 ? 0 : tail++;
    }

    private String dequeue() {
        if (size == 0) {
            throw new IllegalArgumentException("queue is empty!");
        }
        size--;
        int temp = head;
        head = head == items.length - 1 ? 0 : head++;
        return items[temp];
    }

}
