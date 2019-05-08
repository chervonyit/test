package com.app.concurrency.app01.thread.homework.deadlock;

public class Waiter implements Runnable {

    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    public void run(){

        synchronized (msg){
            String name = Thread.currentThread().getName();
            System.out.println("waiter: " + name + " waiter running");
            try {
                msg.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("waiter: waiter got notified, message: " + msg.getMsg());
        }
    }
}
