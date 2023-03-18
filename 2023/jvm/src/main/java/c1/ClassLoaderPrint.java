package c1;

import java.util.Arrays;

public class ClassLoaderPrint {
    public static void main(String[] args) {
        final String s1 = System.getProperty("java.class.path");
        final String s2 = System.getProperty("java.ext.dirs");

        Arrays.stream(s1.split(";")).forEach(System.out::println);
        System.out.println();
        Arrays.stream(s2.split(";")).forEach(System.out::println);
    }
}
