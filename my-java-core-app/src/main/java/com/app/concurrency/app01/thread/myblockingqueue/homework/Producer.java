package com.app.concurrency.app01.thread.myblockingqueue.homework;

public class Producer implements Runnable {

    private int value;
    private boolean produced;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                while (produced) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                value++;
                produced = true;
                System.out.println("Produced value: " + value);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (MainPC.consumer) {
                MainPC.consumer.notify();
            }
        }
    }

    public boolean isProduced() {
        return produced;
    }

    public int consume() {
        produced = false;
        return value;
    }


}
