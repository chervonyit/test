package com.app.concurrency.app01.blockingqueue.array;

import java.util.concurrent.BlockingQueue;

public class MyConsumerApp extends Thread {
    private BlockingQueue blockingQueue;

    public MyConsumerApp(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                System.out.println("\t@Before take()");
                Object res = blockingQueue.take();
                System.out.println("\tConsumed: " + res);
                Thread.sleep(5000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
