package com.app.concurrency.app01.thread.myblockingqueue;

public class Consumer extends Thread {

    public void run(){
        while(true){

            synchronized (this){
                while(!Main.producer.isProduced()){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("\tConsumed: "+Main.producer.consume());
            }

            synchronized (Main.producer){
                Main.producer.notify();
            }

        }
    }
}
