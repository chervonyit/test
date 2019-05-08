package com.app.concurrency.app01.thread.waitnotify;

public class ConsumerThread extends Thread {
    private MetalFactory metalFactory;

    public ConsumerThread(MetalFactory metalFactory) {
        this.metalFactory = metalFactory;
    }

    public void run(){
        int res=metalFactory.consumeGood();
        System.out.println("res="+res);
    }
}
