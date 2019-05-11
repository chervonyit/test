package com.app.concurrency.app01.thread.myblockingqueue.homework;

public class Consumer implements Runnable {

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (!MainPC.producer.isProduced()) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consumed " + MainPC.producer.consume());
            }
            synchronized (MainPC.producer) {
                MainPC.producer.notify();
            }
        }
    }
}
