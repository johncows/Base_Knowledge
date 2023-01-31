package com.kk.containter.lock;

/**
 * @author wangjunkang
 */
public class ThreadLocalDemoTest {

    public static void main(String[] args) {
        ThreadLocal<Object> objectThreadLocal = new ThreadLocal<>();
        objectThreadLocal.set(new Object());
    }
}
