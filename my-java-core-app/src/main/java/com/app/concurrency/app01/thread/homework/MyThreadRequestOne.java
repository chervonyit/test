package com.app.concurrency.app01.thread.homework;

public class MyThreadRequestOne extends Thread {

    @Override
    public void run(){
        long start = System.currentTimeMillis();
        System.out.println("--------------START: " + getName());
        while(System.currentTimeMillis()-start<5000){

        }
        System.out.println("-----------END");
    }
}
