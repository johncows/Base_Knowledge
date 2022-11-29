package lock.homework;

import java.util.ArrayList;
import java.util.List;

public class NotifyContainer {
    private List<Integer> content;

    public NotifyContainer() {
        content = new ArrayList();
        new Thread(() -> {
            while (true) {
                if (content.size() == 5) {
                    System.out.println("长度为5 发出警报");
                    break;
                }
            }
        }).start();
    }

    public void add(Integer element) {
        content.add(element);
    }


    public static void main(String[] args) {
        NotifyContainer notifyContainer = new NotifyContainer();
        for (int i = 0; i < 10; i++) {
            notifyContainer.add(i);
            System.out.println("长度" + notifyContainer.content.size());
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
