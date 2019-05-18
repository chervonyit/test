package com.app.concurrency.app02;

import java.util.TimerTask;

public class MyTask2 extends TimerTask {

    @Override
    public void run() {
        System.out.println("MyTask2. "+Thread.currentThread().getName());
    }
}
