package com.kk.pool.c2;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wangjunkang
 */
public class ThreadPoolFeatureDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        // 执行完成后返回null，单纯的阻塞操作
        Future<?> submit = executorService.submit(new SelfCheckTaskForRunnable());
        System.out.println("future1 ->" + submit.get());

        /**
         *  对Executor来说，
         *  参数一就是一个普通任务，
         *  参数二 指定了一个已有变量，任务提交时 获得对应的feature，当任务执行完成后，通过feature.get 再次获取这个变量
         *
         *  与Callable相比，这种方式可以让一个变量在父子线程间 字字线程间传递，且均能够阻塞获取。
         *
         *  这种提交方式 其实是 对callable接口的一种适配写法 RunnableAdapter imp Callable；而第二个参数 直接result作为返回
         *
         *        public T call() {
         *             task.run();
         *             return result;
         *         }
         *
         *
         */
        StringBuilder stringBuilder = new StringBuilder();
        Future<StringBuilder> future = executorService.submit(new SelfCheckTaskForRunnable(stringBuilder), stringBuilder);
        System.out.println("before-->" + stringBuilder);
        System.out.println("future2 ->" + future.get().toString());
        System.out.println("after-->" + stringBuilder);
    }
}
