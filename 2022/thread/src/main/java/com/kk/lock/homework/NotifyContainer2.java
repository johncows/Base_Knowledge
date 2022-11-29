package com.kk.lock.homework;

import java.util.ArrayList;
import java.util.List;

public class NotifyContainer2 {
    private Object lock = new Object();
    private List<Integer> content;

    public NotifyContainer2() {
        content = new ArrayList();
    }

    public void add(Integer element) throws InterruptedException {
        synchronized (lock) {
            content.add(element);
            if (content.size() == 5) {
                lock.notifyAll();
            }
        }
    }


    public void watch() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (content.size() != 5) {
                    lock.wait();
                } else {
                    System.out.println("长度为5 发出警报");
                    break;
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        NotifyContainer2 notifyContainer = new NotifyContainer2();
        new Thread(() -> {
            try {
                notifyContainer.watch();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        for (int i = 0; i < 10; i++) {
            notifyContainer.add(i);
            System.out.println("长度" + notifyContainer.content.size());
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
