package com.app.concurrency.app01.thread.creation;

public class MyThread  extends Thread {

    /*public MyThread() {
        start();
    }*/

    public void run(){
        long start = System.currentTimeMillis();
        System.out.println("Started");
        start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<5000){
        }
        System.out.println("Finish");
    }

}
