package com.app.concurrency.app01.thread.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();
        Condition condition2 = lock.newCondition();

        MyLockProducer myLockProducer = new MyLockProducer(lock, condition);
        MyLockConsumer myLockConsumer = new MyLockConsumer(lock, condition, myLockProducer);

        MyPlan myPlan = new MyPlan(lock, condition2);
        MyStore myStore = new MyStore(lock, condition2, myPlan);


        myLockProducer.start();
        myLockConsumer.start();

        myPlan.start();
        myStore.start();


    }
}
