package com.app.concurrency.app01.thread.lesson;

public class MainClass {

    public static ConsumerThread consumerThread;
    public static ProducerThread producerThread;

    public static void main(String[] args) {
        producerThread = new ProducerThread();
        consumerThread = new ConsumerThread();

        producerThread.start();
        consumerThread.start();

    }
}
