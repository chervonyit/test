package com.app.concurrency.app01.thread.synch;

public class DataThread extends Thread {
    private BadIncrement badIncrement;
    private int n = 1000;

    public DataThread(BadIncrement badIncrement) {
        this.badIncrement = badIncrement;
    }

    public void run(){
        for(int i=0;i<n;i++){
            badIncrement.increment();
        }
        for(int i=0;i<n;i++){
            badIncrement.decrement();
        }
    }
}
