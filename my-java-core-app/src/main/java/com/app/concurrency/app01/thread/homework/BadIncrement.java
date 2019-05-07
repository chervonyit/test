package com.app.concurrency.app01.thread.homework;

public class BadIncrement {

    private int value;

    public synchronized void increment(){
        value++;
    }

    public synchronized void decrement(){
        value--;
    }

    public int getValue() {
        return value;
    }
}
