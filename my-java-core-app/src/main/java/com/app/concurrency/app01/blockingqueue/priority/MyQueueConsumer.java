package com.app.concurrency.app01.blockingqueue.priority;

import java.util.concurrent.BlockingQueue;

public class MyQueueConsumer extends Thread {
    private BlockingQueue blockingQueue;

    public MyQueueConsumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        try {
            Thread.sleep(10000);
            while (true) {
                Object res = blockingQueue.take();
                System.out.println("\tConsumed: "+res);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
