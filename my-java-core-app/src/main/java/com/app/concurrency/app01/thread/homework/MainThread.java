package com.app.concurrency.app01.thread.homework;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {

        MyThreadRequestOne threadRequestOne = new MyThreadRequestOne();
        MyThreadRequestTwo threadRequestTwo = new MyThreadRequestTwo();

//        threadRequestOne.start();
//        threadRequestTwo.start();

        //--------------Starting Runnable thread
//        RunnableThreadOne runnableThreadOne = new RunnableThreadOne();
//        Thread t1 = new Thread(runnableThreadOne);
//        t1.start();
//        System.out.println("main begin");
//        MyThreadRequestOne[] threads = new MyThreadRequestOne[10];
//        for(int i = 0; i < threads.length; i++){
//            threads[i] = new MyThreadRequestOne();
//            threads[i].start();
//        }
//        for(int i = 0; i < threads.length; i++){
//            threads[i].join();
//        }
//        System.out.println("main end");
//        System.out.println("-----send email once all threads completed");

        BadIncrement badIncrement = new BadIncrement();
        MyDataThread myDataThread1 = new MyDataThread(badIncrement);
        myDataThread1.start();
        MyDataThread myDataThread2 = new MyDataThread(badIncrement);
        myDataThread2.start();
        myDataThread1.join();
        myDataThread2.join();
        System.out.println(badIncrement.getValue());
    }
}
