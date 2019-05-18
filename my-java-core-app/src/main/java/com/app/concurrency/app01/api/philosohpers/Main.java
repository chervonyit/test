package com.app.concurrency.app01.api.philosohpers;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Semaphore f0 = new Semaphore(1);
        Semaphore f1 = new Semaphore(1);
        Semaphore f2 = new Semaphore(1);
        Semaphore f3 = new Semaphore(1);
        Semaphore f4 = new Semaphore(1);


        Philosopher p1 = new Philosopher(f1, f0, "p1");
        Philosopher p2 = new Philosopher(f2, f1, "p2");
        Philosopher p3 = new Philosopher(f3, f2, "p3");
        Philosopher p4 = new Philosopher(f4, f3, "p4");
        Philosopher p5 = new Philosopher(f0, f4, "p5");

        p1.start();
        Thread.sleep(100);
        p2.start();
        Thread.sleep(100);
        p3.start();
        Thread.sleep(100);
        p4.start();
        Thread.sleep(100);
        p5.start();
        Thread.sleep(100);


    }

}
