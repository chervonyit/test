package com.app.concurrency.app03.threadlocal;

import java.util.function.Supplier;

public class DataThread extends Thread {
    private ThreadLocal<MyBadIncrement> threadLocal;

    public DataThread(MyBadIncrement myBadIncrement) {
        threadLocal = ThreadLocal.withInitial(new Supplier<MyBadIncrement>() {
            @Override
            public MyBadIncrement get() {
                return myBadIncrement;
            }
        });
    }

    public void run(){
        for(int i=0;i<1000;i++){
            threadLocal.get().increment();
            //            myBadIncrement.increment();
        }
        for(int i=0;i<1000;i++){
            threadLocal.get().decrement();
            //myBadIncrement.decrement();
        }
    }
}
