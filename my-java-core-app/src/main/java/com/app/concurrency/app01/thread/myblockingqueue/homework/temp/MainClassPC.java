package com.app.concurrency.app01.thread.myblockingqueue.homework.temp;

public class MainClassPC {

    public static ProducerThread producerThread;
    public static ConsumerThread consumerThread;

    public static void main(String[] args) throws InterruptedException {
        producerThread = new ProducerThread();
        consumerThread = new ConsumerThread();

        producerThread.start();
        consumerThread.start();

        System.out.println("main thread before sleep---------");
        Thread.sleep(10000);
        producerThread.interrupt();
        consumerThread.interrupt();
    }
}
