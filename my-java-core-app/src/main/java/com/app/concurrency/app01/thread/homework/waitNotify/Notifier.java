package com.app.concurrency.app01.thread.homework.waitNotify;

public class Notifier implements Runnable {

    private Message msg;

    public Notifier(Message msg) {
        this.msg = msg;
    }

    public void run(){
        synchronized (msg){
            try {
                Thread.sleep(2000);
                msg.setMsg("notifier: message from notifier");
                msg.notify();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("notifier: waiter notified");
        }
    }
}
