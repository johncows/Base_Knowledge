package com.kk.containter.queue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * @author wangjunkang
 */
public class Demo5 {
    public static void main(String[] args) throws InterruptedException {
        TransferQueue<String> queue = new LinkedTransferQueue<String>();

        new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                char c = (char) (65 + i);
                try {
                    System.out.print(queue.take());
                    queue.transfer(c + "");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread01").start();


        new Thread(() -> {
            for (int i = 1; i < 26; i++) {
                try {
                    queue.transfer(i + "");
                    System.out.print(queue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "thread02").start();
    }
}
