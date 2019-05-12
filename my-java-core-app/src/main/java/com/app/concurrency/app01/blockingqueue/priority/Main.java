package com.app.concurrency.app01.blockingqueue.priority;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Main {

    public static void main(String[] args) {
        BlockingQueue blockingQueue = new PriorityBlockingQueue();
        MyQueueProducer myQueueProducer = new MyQueueProducer(blockingQueue);
        MyQueueConsumer myQueueConsumer = new MyQueueConsumer(blockingQueue);
        myQueueProducer.start();
        myQueueConsumer.start();
    }

}
