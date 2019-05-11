package com.app.concurrency.app01.thread.myblockingqueue.homework;

public class MainPC {

    public static Consumer consumer;
    public static Producer producer;

    public static void main(String[] args) throws InterruptedException {
        consumer = new Consumer();
        producer = new Producer();

        Thread consumerThread = new Thread(consumer);
        Thread producerThread = new Thread(producer);
        consumerThread.start();
        producerThread.start();
        consumerThread.join();
        producerThread.join();
        System.out.println("thread finished");
    }
}
