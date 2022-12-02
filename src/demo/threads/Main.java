package demo.threads;

public class Main {

    public static void main2(String[] args) {
//        //Cách taọ thread 1
//        SubThread s1 = new SubThread();
//        s1.start();
//
//        //Cách taọ thread 2
//        SubRun s2 = new SubRun();
//        Thread t1 = new Thread(s2);
//        t1.setPriority(Thread.MAX_PRIORITY);
//        t1.start();
//
//        for (int i = 0; i < 20; i++) {
//            System.out.println("Main i = " + i);
//            try {
//                Thread.sleep(1000);
//            } catch (Exception e) {
//            }
//        }
//
//        //Cách viết gọn
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                //noi dung ham run
//            }
//        };
//        Thread t2 = new Thread(r1);
//        t2.start();
//
//        //Cách viết gọn hơn
//        Runnable r2 = () -> {
//            //noi dung ham run
//        };
//
//        //Cách viết gọn nữa
//        new Thread(() -> {
//            //noi dung ham run
//        }).start();


        Number n = new Number();
        Runnable r = () -> {
            for (int i = 0; i < 20; i++) {
//                n.changeNumber();
//                n.printNumber();
                //Cách 2.1: đồng bộ hóa tài nguyên cấp đối tượng (thread nào dùng n thì khóa vào không cho thread kia truy cập) -> dùng đan xen
                synchronized (n) {
                    n.changeNumber();
                    n.printNumber();
                }
                //Cách 2.2: xem trong class Number
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        t1.start();
        //Cách 1: chờ t1 chạy hết mới đến t2
//        try {
//            t1.join();
//        } catch (Exception e) {
//
//        }
        t2.start();
    }


    public static void main(String[] args) {
        BankAccount ba = new BankAccount();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ba.deposit(200);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        }).start();
        new Thread(() -> {
            ba.withdraw(1000);
        }).start();
    }
}
