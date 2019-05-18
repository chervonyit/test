package com.app.concurrency.app01.api.philosohpers;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private Semaphore leftFork;
    private Semaphore rightFork;
    private String name;

    public Philosopher(Semaphore leftFork, Semaphore rightFork, String name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name=name;
    }

    public void run(){
        while (true){
            try {
                leftFork.acquire();
                System.out.println(name+" Took left");
                Thread.sleep(100);
                rightFork.acquire();
                System.out.println(name+" Took right");
                Thread.sleep(3000);
                rightFork.release();
                leftFork.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}
