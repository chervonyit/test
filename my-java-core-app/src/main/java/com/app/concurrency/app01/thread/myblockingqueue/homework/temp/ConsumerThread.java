package com.app.concurrency.app01.thread.myblockingqueue.homework.temp;

public class ConsumerThread extends Thread {

    @Override
    public void run(){
        while(true){
            synchronized (this){
                while(!MainClassPC.producerThread.isProduced()){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Value consumed by Consumer: " + MainClassPC.producerThread.consume());
            }
            synchronized (MainClassPC.producerThread){
                MainClassPC.producerThread.notify();
            }
        }
    }
}
