package com.kk.pool.c5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author wangjunkang
 */
public class CompletableServiceDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        fun2();
    }

    /**
     * 任务: 提交多个任务，每个任务完成后，通过阻塞队列 及时的将数据处理
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    static void fun1() throws InterruptedException, ExecutionException {
        // construct executorCompletionService
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService(executorService);

        executorCompletionService.submit(() -> {
            Thread.sleep(2_000);
            return "2";
        });

        executorCompletionService.submit(() -> {
            Thread.sleep(4_000);
            return "4";
        });

        executorCompletionService.submit(() -> {
            Thread.sleep(5_000);
            return "5";
        });


        String s = executorCompletionService.take().get();
        System.out.println("s = " + s);
    }

    /**
     * 任务: 提交多个任务，当有一个任务完成后，直接取消任务
     *
     * @throws InterruptedException
     * @throws ExecutionException
     */
    static void fun2() throws InterruptedException, ExecutionException {
        // construct executorCompletionService
        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService(executorService);

        Future<String> f1 = executorCompletionService.submit(() -> {
            Thread.sleep(2_000);
            return "2";
        });

        Future<String> f2 = executorCompletionService.submit(() -> {
            Thread.sleep(4_000);
            return "4";
        });

        Future<String> f3 = executorCompletionService.submit(() -> {
            Thread.sleep(5_000);
            return "5";
        });

        List<Future> futureList = new ArrayList<>();
        futureList.add(f1);
        futureList.add(f2);
        futureList.add(f3);

        Future<String> take = executorCompletionService.take();
        System.out.println(take.isDone());
        System.out.println("s = " + take.get());

        for (Future future : futureList) {
            future.cancel(true);
        }
    }
}
