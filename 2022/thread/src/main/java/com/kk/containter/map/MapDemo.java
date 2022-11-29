package com.kk.containter.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapDemo {

    private static int par = 1;


    public static void main(String[] args) throws InterruptedException {
        // 数据初始化
        DataProvider.init();

        Map<String, String> map = new LinkedHashMap<>();
        int gap = DataProvider.total / par;

        System.out.println("开始测试~");
        long start = System.currentTimeMillis();
        for (int i = 0; i < par; i++) {
            int finalI = i;
            Thread thread = new Thread(() -> {
                for (int j = 0; j < gap; j++) {
                    map.put(DataProvider.keyArr[finalI * gap + j], DataProvider.keyArr[finalI * gap + j]);
                }
            });
            thread.start();
            thread.join();
        }

        System.out.println("耗时=>" + (System.currentTimeMillis() - start));
        System.out.println("尺寸大小" + map.size());
    }
}
