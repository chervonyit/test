package com.app.concurrency.app01.thread.waitnotify;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MetalFactory metalFactory = new MetalFactory();
        ConsumerThread consumerThread1 = new ConsumerThread(metalFactory);
        ConsumerThread consumerThread2 = new ConsumerThread(metalFactory);
        ConsumerThread consumerThread3 = new ConsumerThread(metalFactory);
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

        Thread.sleep(5000);
        metalFactory.producerGood();
    }
}
