package com.app.concurrency.app01.thread.synchron;

public class DataProcessor {
    private int value;

    public void write(int delta){

            System.out.println("write()" + Thread.currentThread());
            long start = System.currentTimeMillis();
            while (System.currentTimeMillis() - start <= 5000) {
            }
            System.out.println(Thread.currentThread().getName());
            while (System.currentTimeMillis() - start <= 6000) {
            }

        synchronized (this) {
            value += delta;
        }
    }

    public int read(){
        return value;
    }

}
