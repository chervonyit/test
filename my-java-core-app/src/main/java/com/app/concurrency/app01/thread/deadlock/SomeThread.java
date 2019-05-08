package com.app.concurrency.app01.thread.deadlock;

public class SomeThread extends Thread {
    private String paramA;
    private String paramB;

    public SomeThread(String paramA, String paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public void run(){
        try {
            Thread.sleep(1000);
            synchronized (paramA){
                System.out.println("Inside paramA. value="+paramA);
                Thread.sleep(1000);
                synchronized(paramB){
                    System.out.println("Inside paramB");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
