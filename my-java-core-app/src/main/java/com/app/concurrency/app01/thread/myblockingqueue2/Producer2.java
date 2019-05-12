package com.app.concurrency.app01.thread.myblockingqueue2;

public class Producer2 extends Thread {
    private Object monitor;
    private boolean produced;
    private int value;

    public Producer2(Object monitor) {
        this.monitor = monitor;
    }

    public void run(){
        while(true){

            synchronized (monitor){

                try {

                    while(produced) {
                        monitor.wait();
                    }

                    value++;
                    System.out.println("Produced: "+value);
                    produced=true;
                    Thread.sleep(1500);


                    //monitor.notifyAll();


                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }

            synchronized (monitor){
                monitor.notifyAll();
            }


        }
    }


    public boolean isProduced(){
        return produced;
    }

    public int consume(){
        produced=false;
        return value;
    }



}
