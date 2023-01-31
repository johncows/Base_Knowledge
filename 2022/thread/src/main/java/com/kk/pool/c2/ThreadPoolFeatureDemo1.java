package com.kk.pool.c2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wangjunkang
 */
public class ThreadPoolFeatureDemo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> submit = executorService.submit(new SelfCheckTask());
        executorService.shutdown();
        System.out.println("do sth");
        // 阻塞式Get
        System.out.println(submit.get());
    }
}
