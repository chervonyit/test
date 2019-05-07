package com.app.concurrency.app01.thread.synch;

public class BadIncrement {
    private int value;

    public void increment(){
        value++;
    }

    public void decrement(){
        value--;
    }

    public int getValue() {
        return value;
    }
}
