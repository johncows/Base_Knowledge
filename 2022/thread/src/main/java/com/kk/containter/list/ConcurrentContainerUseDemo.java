package com.kk.containter.list;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author wangjunkang
 */
public class ConcurrentContainerUseDemo {

    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();
        map.put("zhansgan", "张三");
        map.get("zhansgan");

        ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<>();
    }

}
