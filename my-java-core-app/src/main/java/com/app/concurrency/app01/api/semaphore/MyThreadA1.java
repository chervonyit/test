package com.app.concurrency.app01.api.semaphore;

import java.util.concurrent.Semaphore;

public class MyThreadA1 extends Thread {
    private Semaphore semaphore;
    private String name;

    public MyThreadA1(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name=name;
    }

    public void run(){
        while(true){
            try {
                semaphore.acquire();
                System.out.println(name+"; do JOB");
                Thread.sleep(1000);
                semaphore.release();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
