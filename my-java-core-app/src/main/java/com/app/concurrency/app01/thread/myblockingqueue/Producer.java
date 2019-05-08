package com.app.concurrency.app01.thread.myblockingqueue;

public class Producer extends Thread {
    private int value;
    private boolean produced;

    public void run(){
        while(true){

            synchronized (this){

                while(produced){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                value++;
                produced=true;
                System.out.println("Produced: "+value);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized(Main.consumer){
                Main.consumer.notify();
            }


        }
    }

    public boolean isProduced(){
        return produced;
    }

    public int consume(){
        produced = false;
        return value;
    }

}
