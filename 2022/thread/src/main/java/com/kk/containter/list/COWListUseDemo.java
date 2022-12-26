package com.kk.containter.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class COWListUseDemo {
    public static void main(String[] args) {
        List<String> list = new CopyOnWriteArrayList<>();
        list.add("2");
        list.get(0);
        list.add("3");
        list.add("4");
        list.add("5");
    }
}
