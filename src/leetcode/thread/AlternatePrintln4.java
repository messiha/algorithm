package src.leetcode.thread;

/**
 * @author yan.zhang
 * @date 2023/8/7 10:59
 */
public class AlternatePrintln4 {
    private static int num;
    private static final Object LOCK = new Object();

    public static void main(String[] args) {
        AlternatePrintln4 alternatePrintln4 = new AlternatePrintln4();
        new Thread(() -> {
            alternatePrintln4.print(0);
        }, "A").start();
        new Thread(() -> {
            alternatePrintln4.print(1);
        }, "B").start();
        new Thread(() -> {
            alternatePrintln4.print(2);
        }, "C").start();

    }

    private void print(int targetNum) {
        for (int i = 0; i < 100; i++) {
            synchronized (LOCK) {
                while (num % 3 != targetNum) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                num++;
                System.out.println(Thread.currentThread().getName());
                LOCK.notifyAll();
            }
        }
    }

}
