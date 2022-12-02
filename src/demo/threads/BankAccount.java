package demo.threads;

public class BankAccount {
    int balance = 0;

    public synchronized void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Vừa nạp số tiền: " + amount);
            notify();
            //notifyAll(); //Gọi tất cả các luồng dậy
        }
    }

    public synchronized void withdraw(int amount) {
//        if (amount > 0 && amount < balance) {
//            balance -= amount;
//            System.out.println("Vừa rút số tiền: " + amount);
//        }
        if(amount < 0) {
            System.out.println("Số tiền cần rút không hợp lệ.");
            return;
        }
        while (amount > balance) {
            System.out.println("Không dủ tiền để rút " + amount);
            try {
                //TIMED_WAITING -> Khóa amount
//                Thread.sleep(3000);

                //WAITING -> Mở khóa amount dù hàm có "synchronized"
                wait();
            } catch (Exception e) {
            }
        }
        balance -= amount;
        System.out.println("Vừa rút số tiền: " + amount);
    }

}
