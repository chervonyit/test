package com.app.concurrency.app01.api.countdown.sample1;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        MyThread1 myThread1 = new MyThread1(countDownLatch);
        myThread1.start();

        countDownLatch.await();
        System.out.println("Main completed");


    }

}
