package com.kk.pool.c1;

import java.util.concurrent.*;

/**
 * @author wangjunkang
 */
public class ThreadDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(2, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(2));

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            executorService.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "-> begin execute task" + finalI);
                    Thread.sleep(1_000);
                    System.out.println(Thread.currentThread().getName() + "-> complete task" + finalI);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }
}
