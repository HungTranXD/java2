package demo.threads;

public class Number {
    int x = 0;
    int y = 0;

    public void changeNumber() {
        x++;
        y++;
    }

    public void printNumber() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
    }

    //Cách 2.2: Đồng bộ hóa method
//    public synchronized void changeNumber() {
//        x++;
//        y++;
//    }
//
//    public synchronized void printNumber() {
//        System.out.println("x = " + x);
//        System.out.println("y = " + y);
//    }
}
