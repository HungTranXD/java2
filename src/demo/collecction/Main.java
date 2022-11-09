package demo.collecction;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        HashSet<String> hsStr = new HashSet<>();
        hsStr.add("Hello");
        hsStr.add("world");
        hsStr.add("Hello");//duplicate will not be added

        for(String s: hsStr) {
            System.out.println(s);
        }

        HashMap<String, String> hm = new HashMap<>();
        hm.put("name", "nguyen van an");
        hm.put("email", "an@gmail.com");

        System.out.println("Ten: " + hm.get("name"));

        PriorityQueue<Integer> pi = new PriorityQueue<>();
        pi.add(9);
        pi.add(4);
        pi.add(8);
        pi.add(2);
        while (!pi.isEmpty()) {
            System.out.println(pi.poll());
        }

        Car c1 = new Car("Toyota Camry", 2015);
        Car c2 = new Car("Hyundai Santafe", 2020);
        Car c3 = new Car("BMW X7", 2019);
        PriorityQueue<Car> pc = new PriorityQueue<>(((o1, o2) -> o1.getProducedYear() - o2.getProducedYear()));
        pc.add(c1);
        pc.add(c2);
        pc.add(c3);
        while (!pc.isEmpty()) {
            Car c = pc.poll();
            System.out.println(c.getBrand());
        }
    }
}