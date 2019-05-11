package com.app.concurrency.app01.thread.homework.deadlock;

public class MainDeadLock {

    public static void main(String[] args) {
        String param1 = "a";
        String param2 = "b";

        SomeThread t1 = new SomeThread(param1, param2);
        SomeThread t2 = new SomeThread(param2, param1);
        t1.start();
        t2.start();
    }
}
