package com.app.concurrency.app01.thread.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyLockConsumer extends Thread {
    private Lock lock;
    private Condition condition;
    private MyLockProducer myLockProducer;

    public MyLockConsumer(Lock lock, Condition condition, MyLockProducer myLockProducer) {
        this.lock = lock;
        this.condition = condition;
        this.myLockProducer=myLockProducer;
    }

    public void run(){
        while(true){

            try{
                lock.lock();

                while(!myLockProducer.isProduced()){
                        condition.await();
                }

                int value=myLockProducer.consume();
                System.out.println("\tConsumed: "+value);
                Thread.sleep(2000);

                condition.signalAll();

            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
                lock.unlock();
            }
        }
    }

}
