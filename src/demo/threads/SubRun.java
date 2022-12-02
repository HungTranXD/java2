package demo.threads;

public class SubRun implements Runnable{
    @Override
    public void run() {
        for(int i = 0; i < 20; i++) {
            System.out.println("Run i = " + i);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}
