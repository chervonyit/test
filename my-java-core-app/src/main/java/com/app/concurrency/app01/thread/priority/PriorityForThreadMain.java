package com.app.concurrency.app01.thread.priority;

public class PriorityForThreadMain {

    public static void main(String[] args) {
        MyPriorityThread myPriorityThread1 = new MyPriorityThread();
        myPriorityThread1.setName("T1");
        MyPriorityThread myPriorityThread2 = new MyPriorityThread();
        myPriorityThread2.setName("T2");
        MyPriorityThread myPriorityThread3 = new MyPriorityThread();
        myPriorityThread3.setName("T3");
        MyPriorityThread myPriorityThread4 = new MyPriorityThread();
        myPriorityThread4.setName("T4");
        MyPriorityThread myPriorityThread5 = new MyPriorityThread();
        myPriorityThread5.setName("T5");
        myPriorityThread1.setPriority(Thread.MAX_PRIORITY);
        myPriorityThread2.setPriority(Thread.MIN_PRIORITY);
        myPriorityThread3.setPriority(Thread.MIN_PRIORITY);
        myPriorityThread4.setPriority(Thread.MAX_PRIORITY);
        myPriorityThread5.setPriority(Thread.MAX_PRIORITY);
        myPriorityThread1.start();
        myPriorityThread2.start();
        myPriorityThread3.start();
        myPriorityThread4.start();
        myPriorityThread5.start();
    }
}
