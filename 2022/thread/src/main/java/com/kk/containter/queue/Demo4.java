package com.kk.containter.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author wangjunkang
 */
public class Demo4 {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> queue = new LinkedTransferQueue<String>();

        new Thread(() -> {
            try {
                queue.transfer("1");
                System.out.println("处理完成1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread01").start();

        new Thread(() -> {
            try {
                queue.transfer("2");
                System.out.println("处理完成2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread02").start();


        new Thread(() -> {
            try {
                queue.transfer("3");
                System.out.println("处理完成3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "thread03").start();

        System.out.println(queue.take());

   
    }
}
