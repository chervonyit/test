package com.app.concurrency.app01.thread.lesson;

public class ProducerThread extends Thread {

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
                System.out.println("new value produced, value = " + value);
            }

            synchronized (MainClass.consumerThread){
                MainClass.consumerThread.notify();
            }
        }
    }

    public int consume(){
        produced = false;
        return value;
    }

    public boolean isProduced(){
        return produced;
    }
}
