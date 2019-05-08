package com.app.concurrency.app01.thread.myblockingqueue;

public class Main {

    public static Producer producer;
    public static Consumer consumer;

    public static void main(String[] args) {
        producer = new Producer();
        consumer = new Consumer();
        producer.start();
        consumer.start();
    }

}
