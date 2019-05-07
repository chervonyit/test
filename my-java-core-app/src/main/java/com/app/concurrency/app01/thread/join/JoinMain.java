package com.app.concurrency.app01.thread.join;

import com.app.concurrency.app01.thread.creation.MyThread;

public class JoinMain {


    public static void main(String[] args) throws InterruptedException {
        System.out.println("---------Main  BEGIN------");

        MyThread[] items = new MyThread[10];
        for(int i=0;i<items.length;i++){
            items[i] = new MyThread();
            items[i].start();
            //items[i].join();
        }
        for(int i=0;i<items.length;i++){
            items[i].join();
        }
        System.out.println("---------Main  END------");
        System.out.println("SEND MAIL");
    }



    public static void main1(String[] args) throws InterruptedException {
        System.out.println("---------Main  BEGIN------");
        MyThread myThread = new MyThread();
        //myThread.join();
        myThread.start();
        myThread.join();
        System.out.println("---------Main  END------");
        System.out.println("SEND MAIL");
    }
}
