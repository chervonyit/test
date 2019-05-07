package com.app.concurrency.app01.thread.priority;

public class MyPriorityThread extends Thread {

    public void run(){
        while(true){
            System.out.println(Thread.currentThread().getName());
        }
    }
}
