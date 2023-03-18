package c1;

public class SyncClass {
    public synchronized void m1() {
        System.out.println("hello");
    }

    public void m2() {
        synchronized (this) {
            System.out.println("hello");
        }
    }
}
