package com.app.concurrency.app01.thread.myblockingqueue.homework.ch1;

import java.util.ArrayList;
import java.util.List;

public class MainThreadTest {

    private static int n;

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread() {
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increment();
                    }
                }
            };
            t1.start();
            threads.add(t1);
        }
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("n variable value = " + n);
    }

    private static synchronized int increment() {
        return n++;
    }

}


