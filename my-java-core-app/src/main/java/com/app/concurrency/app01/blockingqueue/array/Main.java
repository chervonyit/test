package com.app.concurrency.app01.blockingqueue.array;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Main {

    public static void main(String[] args) {
        //BlockingQueue blockingQueue = new ArrayBlockingQueue(1);
        BlockingQueue blockingQueue = new SynchronousQueue();

        MyProducerApp myProducerApp = new MyProducerApp(blockingQueue);
        MyConsumerApp myConsumerApp = new MyConsumerApp(blockingQueue);
        myConsumerApp.start();
        myProducerApp.start();
    }
}
