package src.leetcode.thread;

import java.util.concurrent.Semaphore;

/**
 * @author yan.zhang
 * @date 2023/8/7 11:26
 */
public class AlternatePrintln5 {
    private static Semaphore s1 = new Semaphore(1);
    private static Semaphore s2 = new Semaphore(0);
    private static  Semaphore s3 = new Semaphore(0);
    public static void main(String[] args) {
        new Thread(()->{
            try {
                println(s1, s2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"A").start();

        new Thread(()->{
            try {
                println(s2, s3);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"B").start();


        new Thread(()->{
            try {
                println(s3, s1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        },"C").start();

    }

    private static void println(Semaphore cur, Semaphore next) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            cur.acquire();
            System.out.println(Thread.currentThread().getName());
            next.release();
        }
    }

}
