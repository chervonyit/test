package com.app.concurrency.app01.thread.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyStore extends Thread {
    private Lock lock;
    private Condition condition;
    private MyPlan myPlan;

    public MyStore(Lock lock, Condition condition, MyPlan myPlan) {
        this.lock = lock;
        this.condition = condition;
        this.myPlan = myPlan;
    }

    public void run(){
        while(true){

            try{
                lock.lock();

                while(!myPlan.isProduced()){
                    condition.await();
                }

                int data = myPlan.orderData();
                System.out.println("\t\t\t\t\tStore: "+data);

                condition.signalAll();

            }catch(Exception ex){
                ex.printStackTrace();
            }finally{
                lock.unlock();
            }


        }
    }
}
