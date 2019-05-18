package com.app.concurrency.app02;

import java.util.TimerTask;

public class MyTask1 extends TimerTask {

    @Override
    public void run() {
        System.out.println("MyTask1. start. "+Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyTask1. finish"+Thread.currentThread().getName());
    }
}
