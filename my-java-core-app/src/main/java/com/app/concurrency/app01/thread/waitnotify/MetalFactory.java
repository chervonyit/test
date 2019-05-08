package com.app.concurrency.app01.thread.waitnotify;

public class MetalFactory {
    private int goodNumber;
    private boolean hasGood;

    public void producerGood(){
        goodNumber++;
        hasGood=true;
        System.out.println("Produced");
        synchronized (this) {
            this.notifyAll();
        }
    }

    public int consumeGood(){
        synchronized(this){
            if(!hasGood) {
                try {
                    System.out.println("Waiting: "+Thread.currentThread().getName());
                    this.wait();
                    System.out.println("After Waiting: "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("\tConsumed: "+Thread.currentThread().getName());

        return goodNumber;
    }

}
