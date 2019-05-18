package com.app.concurrency.app01.api.countdown.sample2;

import java.util.concurrent.CountDownLatch;

public class MyThread2 extends Thread {
    private CountDownLatch countDownLatch;

    public MyThread2(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run(){
        System.out.println("-----STARTED-----");
        try {
            Thread.sleep(5000);
            countDownLatch.countDown();
            countDownLatch.await();
            System.out.println("Do some job");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
