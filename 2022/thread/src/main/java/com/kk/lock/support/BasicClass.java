package com.kk.lock.support;

public class BasicClass {

    public static synchronized void doSth() {
        System.out.print(Thread.currentThread().getName());
        System.out.println(" begin do sth");
        try {
            Thread.sleep(6_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("complete do sth");
    }

}
