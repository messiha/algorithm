package src.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yan.zhang
 * @date 2022/4/22 17:49
 */
public class AlternatePrintln2 {
    public static void main(String[] args) {
        MyRunnale myRunnale = new MyRunnale();
        Thread thread = new Thread(myRunnale, "0");
        Thread thread1 = new Thread(myRunnale, "1");
        Thread thread2 = new Thread(myRunnale, "2");
        thread1.start();
        thread2.start();
        thread.start();
    }
    private static class MyRunnale implements Runnable {
        private final AtomicInteger atomicInteger;

        MyRunnale() {
            this.atomicInteger = new AtomicInteger(1);
        }

        @Override
        public void run() {
            while (true) {
                synchronized (atomicInteger) {
                    String name = Thread.currentThread().getName();
                    int count = Integer.parseInt(name);
                    int current = atomicInteger.get();
                    if (current > 15) {
                        break;
                    }
                    //当前线程可以打印
                    if (current % 3 == count) {
                        System.out.println(" current Thread " + name + " ----> " + current);
                        atomicInteger.set(current + 1);
                        atomicInteger.notifyAll();
                    } else {
                        try {
                            atomicInteger.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
