import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 2个线程
 * 一个负责打印 1,2,3 -> 26
 * 一个负责打印 a,b,c -> ABC
 * <p>
 * ReentrantLock的使用
 * <p>
 */
public class PrintDemo {

    private ReentrantLock reentrantLock = new ReentrantLock();

    Condition condition123 = reentrantLock.newCondition();
    Condition conditionABC = reentrantLock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        PrintDemo printDemo = new PrintDemo();
        new Thread(printDemo::print123).start();
        new Thread(printDemo::printABC).start();
    }

    void print123() {
        reentrantLock.lock();
        System.out.println("123");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
    }

    void printABC() {
        reentrantLock.lock();
        System.out.println("ABC");
        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
    }

}
