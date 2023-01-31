package com.kk.containter.lock.homework;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2个线程
 * 一个负责打印 1,2,3 -> 26
 * 一个负责打印 a,b,c -> ABC
 * <p>
 * ReentrantLock的使用
 * <p>
 */
public class PrintDemo03 {

    private ReentrantLock reentrantLock = new ReentrantLock();

    Condition condition123 = reentrantLock.newCondition();
    Condition conditionABC = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        PrintDemo03 printDemo = new PrintDemo03();
        new Thread(printDemo::print123, "thread01").start();
        Thread.sleep(2_000);
        new Thread(printDemo::printABC, "thread02").start();
    }

    void print123() {
        reentrantLock.lock();
        for (int i = 0; i < 26; i++) {
            System.out.print(i + 1);
            try {
                if (i == 25) {
                    break;
                }
                condition123.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        reentrantLock.unlock();
    }

    void printABC() {
        reentrantLock.lock();
        for (int i = 0; i < 26; i++) {
            char c = (char) (65 + i);
            System.out.print(c);
            try {
                condition123.signalAll();
                if (i == 25) {
                    break;
                }
                conditionABC.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        reentrantLock.unlock();
    }

}
