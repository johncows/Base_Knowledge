package com.kk.pool.c2;

import java.util.concurrent.Callable;

/**
 * @author wangjunkang
 */
public class SelfCheckTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(5_000);
        return "系统正常";
    }
}