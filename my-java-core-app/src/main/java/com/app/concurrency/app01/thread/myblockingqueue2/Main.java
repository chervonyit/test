package com.app.concurrency.app01.thread.myblockingqueue2;

import com.app.concurrency.app01.thread.myblockingqueue.Consumer;

public class Main {

    public static void main(String[] args) {
        Object monitor = new Object();
        Producer2 producer2 = new Producer2(monitor);
        Consumer2 consumer2 = new Consumer2(monitor, producer2);

        producer2.start();
        consumer2.start();

    }
}
