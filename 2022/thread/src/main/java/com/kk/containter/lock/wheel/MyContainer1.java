package com.kk.containter.lock.wheel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class MyContainer1<T> {


    List<T> coreContainer = new ArrayList<T>();

    Integer count = 0;

    private Integer maxSize = 10;

    private Object lock = new Object();

    // 消费者
    public synchronized T get() throws InterruptedException {
        while (true) {
            if (count == 0) {
                System.out.println("达到最小值,消费者停止消费");
                this.wait();
            } else {
                break;
            }
        }
        T result = coreContainer.remove(0);
        count--;
        this.notifyAll(); // 唤醒生产者
        return result;
    }

    // 生产者
    public synchronized void put(T t) throws InterruptedException {
        while (true) {
            if (count == maxSize) {
                System.out.println(Thread.currentThread().getName() + "达到最大值,生产者停止生产");
                this.wait();
            } else {
                break;
            }
        }
        coreContainer.add(t);
        System.out.println(Thread.currentThread().getName() + "生产数据: " + t);
        count++;
        this.notifyAll(); // 唤醒消费者
    }

    public static void main(String[] args) throws InterruptedException {
        MyContainer1<String> container = new MyContainer1<>();
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                int j = 0;
                while (true) {
                    try {
                        container.put(Thread.currentThread().getName() + j++);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "producer-Thread-" + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                int j = 0;
                while (true) {
                    try {
                        Thread.sleep(10_000);
                        String s = container.get();
                        System.out.println("-------------------------------------------------------");
                        System.out.println(Thread.currentThread().getName() + "消费了 " + s);
                        System.out.println("-------------------------------------------------------");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "consumer-Thread-" + i).start();
        }

        countDownLatch.await();


    }
}
