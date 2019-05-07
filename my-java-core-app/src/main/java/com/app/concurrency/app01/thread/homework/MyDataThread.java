package com.app.concurrency.app01.thread.homework;

public class MyDataThread extends Thread {

    private BadIncrement badIncrement;
    private int n = 10000;

    public MyDataThread(ThreadGroup group, String threadName, BadIncrement badIncrement){
        super(group, threadName);
        this.badIncrement = badIncrement;
    }

    @Override
    public void run(){
        for(int i = 0; i < n; i++){
            badIncrement.increment();
        }
        for(int i = 0; i < n; i++){
            badIncrement.decrement();
        }
    }
}
