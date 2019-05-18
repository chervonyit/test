package com.app.concurrency.app01.thread.myblockingqueue3.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class MyConsumerThread extends Thread {

    BlockingQueue<Integer> blockingQueue;

    public MyConsumerThread(BlockingQueue blockingQueue){
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run(){
        while(true) {
            try {
                int value = blockingQueue.take();
                System.out.println("consumed value = " + value);
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
