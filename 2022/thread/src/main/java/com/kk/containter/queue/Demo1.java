package com.kk.containter.queue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author wangjunkang
 */
public class Demo1 {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue<String>(10);
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            queue.put(random.nextInt() + "");
        }

//        // queue full
//        queue.add("张三");
//
//        // return false  when  queue full
//        queue.offer("张三");

        // blocking  when  queue full , and wait queue not full
        queue.put("张三");
    }

}
