package com.app.concurrency.app01.thread.creation;

public class Main {





    public static void main(String[] args) {
        System.out.println("---------Main  BEGIN------");
        MyThread myThread = new MyThread();
        //myThread.setDaemon(true);

  //      myThread.run();
  //      myThread.run();
        myThread.start();
        //myThread.run();
        System.out.println("---------Main  END------");

    }









    public static void mainOld(String[] args) {

        System.out.println("Started");
        long start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<5000){
        }
        System.out.println("Finish");

        System.out.println("Started");
        start = System.currentTimeMillis();
        while(System.currentTimeMillis()-start<5000){
        }
        System.out.println("Finish");
    }

}
