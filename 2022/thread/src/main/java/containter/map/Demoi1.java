package containter.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Demoi1 {
    public static void main(String[] args) {
        Map<Product, String> map = new ConcurrentHashMap<>();
        map.put(new Product("1"), "456");
        map.put(new Product("2"), "789");
        map.put(new Product("3"), "789");
    }
}
