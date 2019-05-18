package com.app.concurrency.app01.thread.myblockingqueue3.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class MyProducerThread extends Thread {

    private int value;
    private BlockingQueue<Integer> blockingQueue;

    public MyProducerThread(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run(){
        while(true) {
            value++;
            try {
                blockingQueue.put(value);
                System.out.println("new value produced = " + value);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
