package com.app.concurrency.app01.thread.myblockingqueue3;

public class MainClassBlockingQueue {

    public static void main(String[] args) {
        Object monitor = new Object();

        ProducerThread producerThread = new ProducerThread(monitor);
        ConsumerThread consumerThread = new ConsumerThread(monitor, producerThread);

        producerThread.start();
        consumerThread.start();

    }
}
