package com.app.concurrency.app01.thread.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLockProducer extends Thread {
    private Lock lock;
    private Condition condition;
    private int value;
    private boolean produced;

    public MyLockProducer(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run(){
        while(true){
            try {
                lock.lock();

                while(produced){
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                value++;
                System.out.println("Produced: "+value);
                produced=true;
                condition.signalAll();

            } finally {
                lock.unlock();
            }

        }

        /*synchronized (lock){
            throws new RuntimeException();
        }*/
    }


    public boolean isProduced(){
        return produced;
    }

    public int consume(){
        produced = false;
        return value;
    }


}
