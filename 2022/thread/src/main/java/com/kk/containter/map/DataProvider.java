package com.kk.containter.map;

import java.util.UUID;

public class DataProvider {

    static int total = 10_000_000;

    static String[] keyArr;

    static String[] valueArr;


    public static void init() {
        keyArr = new String[total];
        valueArr = new String[total];
        for (int i = 0; i < total; i++) {
            keyArr[i] = UUID.randomUUID().toString();
            keyArr[i] = UUID.randomUUID().toString();
        }
    }

}
