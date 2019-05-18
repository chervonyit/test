package com.app.concurrency.app01.api.barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread3 extends Thread {
    private CyclicBarrier cyclicBarrier;

    public MyThread3(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    public void run(){
        System.out.println("------------STARTED----------");
        try {
            cyclicBarrier.await();
            System.out.println("Do some job");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
