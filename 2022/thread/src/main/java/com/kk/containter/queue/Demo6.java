package com.kk.containter.queue;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author wangjunkang
 */
public class Demo6 {
    public static void main(String[] args) {
        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();

        queue.add("12");
        queue.remove();

        PriorityBlockingQueue<Object> objects = new PriorityBlockingQueue<>();
        objects.put(new Object());
    }
}
