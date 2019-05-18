package com.app.concurrency.app01.api.countdown.sample1;

import java.util.concurrent.CountDownLatch;

public class MyThread1 extends Thread {
    private CountDownLatch countDownLatch;

    public MyThread1(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run(){
        System.out.println("Started!!!");
        countDownLatch.countDown();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
        System.out.println("----Finished!!!-----");
    }
}
