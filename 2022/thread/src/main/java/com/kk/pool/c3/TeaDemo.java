package com.kk.pool.c3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wangjunkang
 */
public class TeaDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 需要获取任务一完成后的通知，才可以泡茶
        Future task1 = executorService.submit(new TeaTask1());
        executorService.submit(new TeaTask2(task1));
        executorService.shutdown();
    }

    // 洗水壶 烧开水
    static class TeaTask1 implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(2_000L);
                System.out.println("洗水壶");
                Thread.sleep(10_000L);
                System.out.println("烧开水");
            } catch (Exception exception) {

            }
        }
    }

    // 洗茶杯 洗茶壶 拿茶叶 泡茶
    static class TeaTask2 implements Runnable {

        private Future task1Feature;

        public TeaTask2(Future task1) {
            this.task1Feature = task1;
        }

        @Override
        public void run() {
            try {
                System.out.println("洗茶杯");
                Thread.sleep(2_000L);
                System.out.println("洗茶壶");
                Thread.sleep(2_000L);
                System.out.println("拿茶叶");
                // 等待水开
                if (!task1Feature.isDone()) {
                    System.out.println("等待热水烧好～");
                }
                task1Feature.get();
                System.out.println("-----泡茶-----");
            } catch (Exception exception) {

            }

        }
    }
}
