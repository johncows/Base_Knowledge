package com.kk.pool;

import java.util.concurrent.Callable;

/**
 * @author wangjunkang
 */
public class MyTask implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(1_000);
        System.out.println("方法调用中 ！！！");
        return "执行成功";
    }
}
