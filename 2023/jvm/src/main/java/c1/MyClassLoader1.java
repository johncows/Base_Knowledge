package c1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader1 extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("进入加载页面~~");
        String basePath = "D:\\personal\\";
        String path = basePath + name.replace('.', '\\').concat(".class");
        File file = new File(path);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);


            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b = -1;
            while (true) {
                if (!((b = fileInputStream.read()) != -1)) break;
                byteArrayOutputStream.write(b);
            }

            byte[] bytes = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            fileInputStream.close();
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception exception) {
            return super.findClass(name);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader1 myClassLoader1 = new MyClassLoader1();
        Class<?> aClass1 = myClassLoader1.loadClass("c1.EmptyClass");
        Class<?> aClass2 = myClassLoader1.loadClass("c1.EmptyClass");
        System.out.println(aClass1 == aClass2);
    }
}
