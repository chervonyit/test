package com.app.concurrency.app01.blockingqueue.array;

import java.util.concurrent.BlockingQueue;

public class MyProducerApp extends Thread {
    private BlockingQueue blockingQueue;
    private int value;

    public MyProducerApp(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {
        while (true) {
            try {
                value++;
                System.out.println("\t@Before put()");
                blockingQueue.put(value);
                System.out.println("Produced: "+value);
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
