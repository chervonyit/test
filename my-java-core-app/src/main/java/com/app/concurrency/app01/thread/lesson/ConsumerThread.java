package com.app.concurrency.app01.thread.lesson;

public class ConsumerThread extends Thread {

    @Override
    public void run(){
        while(true){
            synchronized (this){
                while(!MainClass.producerThread.isProduced()){
                    try{
                        wait();
                    } catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
                System.out.println("\t\tConsumer consumed newly created value = " + MainClass.producerThread.consume());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            synchronized (MainClass.producerThread){
                MainClass.producerThread.notify();
            }
        }
    }
}
