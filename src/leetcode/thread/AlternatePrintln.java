package src.leetcode.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author yan.zhang
 * @Date 2022/4/21 14:07
 * @Version 1.0
 */
public class AlternatePrintln {
    /**
     * 三个线程交替打印123
     * https://blog.csdn.net/dadiyang/article/details/88378061
     * 思路重点：三个线程交替打印，无法通过一个锁完成。因为多个线程在等待的情况下，无法通过notify唤醒指定线程。
     */
    public static void main(String[] args) {
        new AlternatePrintln().start();
    }
    ReentrantLock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();
    Condition c3 = lock.newCondition();
    private int no = 1;

    private void start() {
        //当线程1执行时,先获取t2的锁，然后再获取自己的锁，当两个锁都持有，执行打印。并唤醒
        AlternatePrintln alternatePrintln = new AlternatePrintln();
        new Thread(() -> {
            while (true) {
                alternatePrintln.process1();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                alternatePrintln.process2();
            }
        }).start();
        new Thread(() -> {
            while (true) {
                alternatePrintln.process3();
            }
        }).start();
    }

    public void process1() {
        lock.lock();
        try {
            if (no != 1) {
                c1.await();
            }
            System.out.println(no);
            no = 2;
            c2.signal();
        } catch (Exception ignored) {
        } finally {
            lock.unlock();
        }
    }

    public void process2() {
        lock.lock();
        try {
            if (no != 2) {
                c2.await();
            }
            System.out.println(no);
            no = 3;
            c3.signal();
        } catch (Exception ignored) {
        } finally {
            lock.unlock();
        }
    }

    public void process3() {
        lock.lock();
        try {
            if (no != 3) {
                c3.await();
            }
            System.out.println(no);
            no = 1;
            c1.signal();
        } catch (Exception ignored) {
        } finally {
            lock.unlock();
        }

    }
}

