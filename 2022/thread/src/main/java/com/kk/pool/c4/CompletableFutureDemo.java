package com.kk.pool.c4;

import java.util.concurrent.CompletableFuture;

/**
 * @author wangjunkang
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {
        CompletableFuture.supplyAsync(() -> {
                    String speck = "hello world";
                    System.out.println(Thread.currentThread().getName() + " " + speck);
                    return speck;
                }).thenApply((e) -> e + " qq")
                .thenApply(String::toUpperCase)
                .thenAcceptAsync(e -> System.out.println(Thread.currentThread().getName() + " " + e));
    }
}
