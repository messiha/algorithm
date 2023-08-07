package src.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author yan.zhang
 * @date 2023/8/7 11:32
 */
public class AlternatePrintln6 {
    private static int num;
    private static final ReentrantLock LOCK = new ReentrantLock();
    private static final Condition c1 = LOCK.newCondition();
    private static final Condition c2 = LOCK.newCondition();
    private static final Condition c3 = LOCK.newCondition();

    private static void printABC(int target, Condition cur, Condition next) {
        for (int i = 0; i < 100; i++) {
            LOCK.lock();
            try {
                while (num % 3 != target) {
                    try {
                        cur.await();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(Thread.currentThread().getName());
                num++;
                next.signal();
            } finally {
                LOCK.unlock();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(() -> {
            printABC(0, c1, c2);
        }, "A").start();
        new Thread(() -> {
            printABC(1, c2, c3);
        }, "B").start();
        new Thread(() -> {
            printABC(2, c3, c1);
        }, "C").start();
    }
}
