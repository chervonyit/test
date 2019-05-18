package com.app.concurrency.app01.api.countdown.sample2;

import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        Thread[] data = new MyThread2[10];
        for(int i=0;i<data.length-1;i++){
            data[i] = new MyThread2(countDownLatch);
            data[i].start();
        }

        Thread.sleep(10000);

        data[9] = new MyThread2(countDownLatch);
        data[9].start();

    }
}
