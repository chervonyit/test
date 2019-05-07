package com.app.concurrency.app01.thread.synch;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BadIncrement badIncrement = new BadIncrement();
        DataThread dataThread1 = new DataThread(badIncrement);
        dataThread1.start();
        DataThread dataThread2 = new DataThread(badIncrement);
        dataThread2.start();
        dataThread1.join();
        dataThread2.join();
        System.out.println(badIncrement.getValue());
    }
}
