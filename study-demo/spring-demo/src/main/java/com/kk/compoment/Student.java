package com.kk.compoment;

import lombok.Data;

@Data
public class Student {

    private String id;

    private String name;

    public void init(){
        System.out.println("我已经被初始化了");
    }

    public void before(){
        System.out.println("我已经被初始化了-before");
    }

    public void after(){
        System.out.println("我已经被初始化了-after");
    }

}
