package com.app.concurrency.app01.thread.myblockingqueue3;

public class ConsumerThread extends Thread {

    private Object monitor;
    private ProducerThread producerThread;

    public ConsumerThread(Object monitor, ProducerThread producerThread) {
        this.monitor = monitor;
        this.producerThread = producerThread;
    }

    @Override
    public void run(){
        while(true){
            synchronized (monitor){
                while(!producerThread.isProduced()){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("\t\t\tNew value consumed " + producerThread.consume());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                monitor.notify();
            }

//            synchronized (monitor){
//                monitor.notify();
//            }
        }
    }


}
