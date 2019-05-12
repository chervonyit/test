package com.app.concurrency.app01.thread.myblockingqueue.homework.temp;

public class ProducerThread extends Thread {

    private int value;
    private boolean produced;

    public int getValue(){
        return value;
    }

    public boolean isProduced(){
        return produced;
    }

    public int consume(){
        produced = false;
        return value;
    }

    @Override
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
                produced = true;
                System.out.println("new value produced = " + getValue());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (MainClassPC.consumerThread){
                    MainClassPC.consumerThread.notify();
                }
            }
        }
    }
}
