package com.kk.cheapter10;

import java.util.concurrent.CountDownLatch;

public class ThreadLocalSimpleTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal() {
        // 重写initvalue
        @Override
        protected String initialValue() {
            return "在下 李四";
        }
    };

    public static void main(String[] args) throws InterruptedException {
//        threadLocal.set("在下张三");

//        Thread.sleep(2_000);
//
//        String s = threadLocal.get();
//        System.out.println("s = " + s);


        final CountDownLatch countDownLatch = new CountDownLatch(1);
        countDownLatch.countDown();
        System.out.println("countDownLatch = " + countDownLatch);
    }
}
