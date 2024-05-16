package test.myThread;

import java.util.concurrent.atomic.AtomicInteger;

public class CountAddAddIsSafe extends Thread{
    private static volatile int count = 0;
    private static volatile AtomicInteger count1 = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new CountAddAddIsSafe().start();
        }
        Thread.sleep(10000);
        System.out.println(CountAddAddIsSafe.count);
        System.out.println(CountAddAddIsSafe.count1);
    }

    @Override
    public void run(){
        for (int i = 0; i < 100000; i++) {
            CountAddAddIsSafe.count++;
            count1.addAndGet(1);
        }
    }
}
