package practice.effective_java;

import java.util.concurrent.TimeUnit;

public class SharedMutableData {
    protected static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Runnable target;
        Thread bakcground = new Thread(() -> {
            int i = 0;
            while (!stopRequested()) {
                i++;
                System.out.println(i);
            }
            System.out.println("From internal thread");
        });
        bakcground.start();
        TimeUnit.SECONDS.sleep(1);
        stopRequest();
        System.out.println("DONE");
    }

    private static synchronized boolean stopRequested(){
        return stopRequested;
    }

    private static synchronized boolean stopRequest(){
        return stopRequested=true;
    }
}
