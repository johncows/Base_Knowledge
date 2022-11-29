package com.kk.lock.homework;

/**
 * 2个线程
 * 一个负责打印 1,2,3 -> 26
 * 一个负责打印 a,b,c -> ABC
 * <p>
 * 这串代码也验证了 notify 这个时间如果 等待队列没有线程,就会失效
 * 另外 疑惑的 notify + wait 会不会导致 唤醒线程立刻争抢,发现锁未释放的问题 也不存在,线程被唤醒后进入的是 runnable状态, 重点在与 wait不结束,其他线程就会排队,无法执行
 */
public class PrintDemo01 {


    synchronized void print123() {
        for (int i = 0; i < 26; i++) {
            System.out.print(i + 1);
            try {
                if (i < 3) {
                    this.notify();
                }
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void printABC() {
        for (int i = 0; i < 26; i++) {
            char c = (char) (65 + i);
            System.out.print(c);
            try {
                this.notify();
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) throws InterruptedException {
        PrintDemo01 printDemo = new PrintDemo01();
        new Thread(printDemo::print123).start();
        Thread.sleep(5_000);
        new Thread(printDemo::printABC).start();
    }

}
