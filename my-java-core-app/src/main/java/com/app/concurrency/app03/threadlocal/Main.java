package com.app.concurrency.app03.threadlocal;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        MyBadIncrement myBadIncrement = new MyBadIncrement();
        DataThread t1 = new DataThread(myBadIncrement);
        DataThread t2 = new DataThread(myBadIncrement);
        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(myBadIncrement);
    }
}
