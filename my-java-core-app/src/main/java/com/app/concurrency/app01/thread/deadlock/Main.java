package com.app.concurrency.app01.thread.deadlock;

public class Main {

    public static void main(String[] args) {
        String paramA = "A";
        String paramB = "B";
        SomeThread someThread1 = new SomeThread(paramA, paramB);
        SomeThread someThread2 = new SomeThread(paramB, paramA);
        someThread1.start();
        someThread2.start();
    }

}
