package com.app.concurrency.app01.thread.myblockingqueue3.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyMainThread {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

        MyProducerThread myProducerThread = new MyProducerThread(blockingQueue);
        MyConsumerThread myConsumerThread = new MyConsumerThread(blockingQueue);

        myProducerThread.start();
        myConsumerThread.start();
    }
}
