package com.app.concurrency.app01.thread.homework.deadlock;

public class SomeThread extends Thread {

    private String parama;
    private String paramb;

    public SomeThread(String parama, String paramb) {
        this.parama = parama;
        this.paramb = paramb;
    }

    public void run(){
        synchronized (parama){
            System.out.println("param A");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (paramb){
                System.out.println("param b");
            }
        }
    }
}
