package com.kk.containter.lock.wheel;

/**
 * await 阻塞自己当前线程
 * countDown 自动减1
 * 为0时 允许继续执行
 * <p>
 * 实现一个简易的 countDownLatch
 */
public class MyCountDownLatch {
    private Object lock;
    private Integer countNum;

    public MyCountDownLatch(Integer countNum) {
        this.countNum = countNum;
        lock = new Object();
    }


    public void await() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (countNum > 0) {
                    lock.wait();
                } else {
                    break;
                }
            }
            System.out.println("继续执行");
        }
    }

    public void countDown() {
        synchronized (lock) {
            countNum -= 1;
            if (countNum == 0) {
                lock.notifyAll();
            }
        }
    }
}
