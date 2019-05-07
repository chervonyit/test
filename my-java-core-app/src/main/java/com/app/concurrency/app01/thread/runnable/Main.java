package com.app.concurrency.app01.thread.runnable;

import com.app.concurrency.app01.thread.creation.MyThread;

public class Main {

    public static void main(String[] args) {
        UsefulJob usefulJob = new UsefulJob();
       // usefulJob.run();

        Thread t1 = new Thread(usefulJob);
        t1.start();
        Thread t2 = new Thread(usefulJob);
        t2.start();
        MyThread myThread = new MyThread();
        Thread t3 = new Thread(myThread);
        t3.start();


        System.out.println("-----Main end----");
    }
}
