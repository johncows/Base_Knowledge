package com.kk.containter.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * 代码 演示 countdownLatch,CyclicBarrier,ReentrantLock 用法
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        new Demo2().fun1();
    }

    void fun1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " begin execute job");
                try {
                    Thread.sleep(3_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " finish execute job");
                countDownLatch.countDown();
            }, "thread" + i).start();
        }

        System.out.println("等待任务执行");
        countDownLatch.await();
        System.out.println("任务执行完成");
    }

    void fun2() {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "  execute job");
            }, "thread" + i).start();

            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    void fun3() {

    }

}
