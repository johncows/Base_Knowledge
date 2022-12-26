package com.kk.containter.queue.support;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author wangjunkang
 */
public class MyTask implements Delayed {

    private long executeTime;

    private String taskName;

    public MyTask(String taskName, long executeTime) {
        this.executeTime = executeTime;
        this.taskName = taskName;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return (executeTime - System.currentTimeMillis()) * 1_000;
    }

    @Override
    public int compareTo(Delayed o) {
        return -(int) (o.getDelay(TimeUnit.NANOSECONDS) - getDelay(TimeUnit.NANOSECONDS));
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "executeTime=" + executeTime +
                ", taskName='" + taskName + '\'' +
                '}';
    }
}
