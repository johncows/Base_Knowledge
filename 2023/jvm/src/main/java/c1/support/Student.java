package c1.support;

public class Student {

    public static final String name = "张三";

    static {
        System.out.println("I am init");
    }


    public static void hook() {
        System.out.println("I am hook");
    }
}
