package lock;


import com.kk.threadstudy.lock.support.BasicClass;
import com.kk.threadstudy.lock.support.SubClass;

/**
 * 这个demo 需要验证以下问题
 * 1. sync class锁 在子类与父类同时调用时 是否会产生阻塞
 * 2. try catch finally 如果忽略catch 是否可以执行到finally
 * 3，
 */

public class Demo1 {

    public static void main(String[] args) {
//        new Demo1().fun1();
        new Demo1().fun2();
    }

    /**
     * 期望 打印出 解锁字样，并报错
     * OK
     */
    void fun1() {
        try {
            System.out.println("上锁");
            throw new RuntimeException("执行错误");
        } finally {
            System.out.println("解锁");
        }
    }

    /**
     * except BasicClass AND SubClass continue execute
     * 相互正常运行 锁的不是同一个资源
     */
    void fun2() {
        new Thread(BasicClass::doSth, "父类方法").start();
        new Thread(SubClass::doSth, "子类方法").start();
    }

    void fun3() {
    }

    void fun4() {
    }
}
