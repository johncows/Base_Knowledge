package lock.homework;

/**
 * 2个线程
 * 一个负责打印 1,2,3 -> 26
 * 一个负责打印 a,b,c -> ABC
 * <p>
 * 这串代码表示 管程定义的锁 内部调用wait notify才生效
 * <p>
 */
public class PrintDemo02 {

    private Object p123Lock = new Object();
    private Object pABCLock = new Object();


    void print123() {
        synchronized (p123Lock) {
            for (int i = 0; i < 26; i++) {
                System.out.print(i + 1);
                try {
                    p123Lock.wait();
                    pABCLock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    void printABC() {
        synchronized (pABCLock) {
            for (int i = 0; i < 26; i++) {
                char c = (char) (65 + i);
                System.out.print(c);
                try {
                    pABCLock.wait();
                    p123Lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        PrintDemo02 printDemo = new PrintDemo02();
        new Thread(printDemo::print123).start();
        new Thread(printDemo::printABC).start();
    }

}
