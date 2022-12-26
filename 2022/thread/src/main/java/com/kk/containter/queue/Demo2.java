package com.kk.containter.queue;

import com.kk.containter.queue.support.MyTask;

import java.util.concurrent.DelayQueue;

/**
 * @author wangjunkang
 * <p>
 * DelayQueue采用PriorityQueue存储元素,采用ReentrantLock实现线程同步,采用Delayed接口获取剩余时间来实现一个优先级队列.
 * <p>
 * 1 PriorityQueue 会对插入的数据 进行排序
 * 2 ReentrantLock 提供了当队列数据无法获取时 进行Time_wait
 * 3 Delyed 接口提供了排序的方式，并通过当前时间与Delay时间进行相减
 */
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<MyTask> queue = new DelayQueue<MyTask>();
        long now = System.currentTimeMillis();
        queue.add(new MyTask("task1", now + 5_00000000));

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread01").start();

        Thread.sleep(1_000);

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread02").start();

    }

}
