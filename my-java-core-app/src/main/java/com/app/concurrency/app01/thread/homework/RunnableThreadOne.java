package com.app.concurrency.app01.thread.homework;

public class RunnableThreadOne implements Runnable {

    public void run(){
        long start = System.currentTimeMillis();
        System.out.println("---------RUNNABLE START");
        while(System.currentTimeMillis()-start<5000){

        }
        System.out.println("------------RUNNABLE END");
    }
}
