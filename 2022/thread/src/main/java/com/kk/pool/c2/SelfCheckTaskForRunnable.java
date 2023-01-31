package com.kk.pool.c2;

/**
 * @author wangjunkang
 */
public class SelfCheckTaskForRunnable implements Runnable {

    private StringBuilder info;

    public SelfCheckTaskForRunnable(StringBuilder info) {
        this.info = info;
    }

    public SelfCheckTaskForRunnable() {
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("执行完成～");
        if (info != null) {
            info.append("嘟嘟嘟");
        }
    }
}