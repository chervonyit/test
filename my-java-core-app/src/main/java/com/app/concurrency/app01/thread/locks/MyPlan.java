package com.app.concurrency.app01.thread.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class MyPlan extends Thread {
    private Lock lock;
    private Condition condition;
    private boolean produced;
    private int dataValue;

    public MyPlan(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    public void run() {
        while (true) {

            try {
                lock.lock();

                while (produced) {
                    condition.await();
                }

                dataValue--;
                System.out.println("\t\t\t\tPlan created: " + dataValue);
                produced = true;
                Thread.sleep(10000);

                condition.signalAll();

            } catch (Exception ex) {
                ex.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }


    public boolean isProduced() {
        return produced;
    }

    public int orderData() {
        produced = false;
        return dataValue;
    }
}
