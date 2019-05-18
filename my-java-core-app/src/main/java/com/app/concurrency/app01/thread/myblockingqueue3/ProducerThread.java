package com.app.concurrency.app01.thread.myblockingqueue3;

public class ProducerThread extends Thread {

    private int value;
    private boolean produced;
    private Object monitor;

    public ProducerThread(Object monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                while (produced) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                value++;
                produced = true;
                System.out.println("new value produced " + value);
            }
            synchronized (monitor){
                monitor.notify();
            }
        }
    }

    public int consume() {
        produced = false;
        return value;
    }

    public boolean isProduced() {
        return produced;
    }
}
