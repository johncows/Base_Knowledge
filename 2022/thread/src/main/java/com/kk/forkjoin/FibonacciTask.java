package com.kk.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * @author wangjunkang
 */
public class FibonacciTask extends RecursiveTask<Integer> {

    final int i;

    public FibonacciTask(int i) {
        this.i = i;
    }

    @Override
    protected Integer compute() {
        if (i < 2) {
            return i;
        }

        FibonacciTask fibonacciTask1 = new FibonacciTask(i - 1);
        fibonacciTask1.fork();

        FibonacciTask fibonacciTask2 = new FibonacciTask(i - 2);
        fibonacciTask2.fork();

    }
}
