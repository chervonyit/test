package com.app.concurrency.app01.thread.myblockingqueue2;

public class Consumer2 extends Thread {
    private Object monitor;
    private Producer2 producer2;

    public Consumer2(Object monitor, Producer2 producer2) {
        this.monitor = monitor;
        this.producer2 = producer2;
    }

    public void run(){
        while(true){

            synchronized (monitor){
                try{

                    while(!producer2.isProduced()){
                        monitor.wait();
                    }


                    int value=producer2.consume();
                    System.out.println("\tConsumed:"+value);



                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }

            synchronized (monitor){
                monitor.notifyAll();
            }


        }
    }
}
