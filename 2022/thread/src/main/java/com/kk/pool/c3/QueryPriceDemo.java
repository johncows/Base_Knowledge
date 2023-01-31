package com.kk.pool.c3;

import java.util.concurrent.*;

/**
 * @author wangjunkang
 * <p>
 * 做一个询价应用,这个应用需要从三个电商询价,然后保存在自己的数据库里
 */
public class QueryPriceDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        fun3();
    }

    /**
     * use countdownLatch
     */
    public static void fun1() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("jd" + "价格为 1001");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(5_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("tb" + "价格为 1000");
            countDownLatch.countDown();
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(15_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("pdd" + "价格为 999");
            countDownLatch.countDown();
        }).start();

        System.out.println("等待 三家电商的 结果汇算");
        countDownLatch.await();
        System.out.println("save");
    }

    public static void fun2() throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("jd" + "价格为 1001");
        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(5_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("tb" + "价格为 1000");
        });

        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(15_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("pdd" + "价格为 999");
        });


        System.out.println("等待 三家电商的 结果汇算");

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();
        System.out.println("save");
    }

    public static void fun3() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<?> submit1 = executorService.submit(() -> {
            try {
                Thread.sleep(4_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("jd" + "价格为 1001");
        });

        Future<?> submit2 = executorService.submit(() -> {
            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("tb" + "价格为 1000");
        });

        Future<?> submit3 = executorService.submit(() -> {
            try {
                Thread.sleep(12_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("pdd" + "价格为 999");
        });

        System.out.println("等待 三家电商的 结果汇算");
        submit1.get();
        submit2.get();
        submit3.get();
        System.out.println("save");

        executorService.shutdown();
    }
}
