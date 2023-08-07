package src.leetcode.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author yan.zhang
 * @date 2023/8/7 10:22
 */
public class AlternatePrintln3 {
    CyclicBarrier cb = new CyclicBarrier(3);
    private volatile int n = 1;

    public static void main(String[] args) {
        new AlternatePrintln3().start();
    }

    private void start() {
        new Thread(() -> {
            try {
                process1();
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "A").start();
        new Thread(() -> {
            try {
                process2();
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "B").start();
        new Thread(() -> {
            try {
                process3();
            } catch (BrokenBarrierException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "C").start();
    }

    private void process1() throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            cb.await();
        }

    }

    private void process2() throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 1) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            cb.await();

        }
    }

    private void process3() throws BrokenBarrierException, InterruptedException {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 2) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            cb.await();
        }
    }
}
