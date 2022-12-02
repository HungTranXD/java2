package demo.generics;

public class Main {
    public static void main (String[] args) {
        Demo<String> ds = new Demo<>();
        ds.element = "Hello";

        Demo<Integer> di= new Demo<>();
        di.element = 20;

        di.print("hello world");
    }
}
