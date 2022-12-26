package com.kk.containter.queue;

import java.util.concurrent.SynchronousQueue;

/**
 * @author wangjunkang
 */
public class Demo3 {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                Thread.sleep(5_000);
                System.out.println(synchronousQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        synchronousQueue.put("合肥");
    }
}
