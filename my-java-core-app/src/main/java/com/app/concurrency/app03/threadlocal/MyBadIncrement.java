package com.app.concurrency.app03.threadlocal;

public class MyBadIncrement {
    private int value;

    public void increment() {
        value++;
    }

    public void decrement() {
        value--;
    }

    @Override
    public String toString() {
        return "MyBadIncrement{" +
                "value=" + value +
                '}';
    }
}
