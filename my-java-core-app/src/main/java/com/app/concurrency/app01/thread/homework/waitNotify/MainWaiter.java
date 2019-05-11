package com.app.concurrency.app01.thread.homework.waitNotify;

public class MainWaiter {

    public static void main(String[] args) {
        Message message = new Message("someMessage");

        Waiter w1 = new Waiter(message);
        new Thread(w1, "w1").start();

        Waiter w2 = new Waiter(message);
        new Thread(w2, "w2").start();

        Notifier notifier = new Notifier(message);
        new Thread(notifier, "notified").start();

        System.out.println("all thread started");
    }
}
