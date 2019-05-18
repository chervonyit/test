package com.app.concurrency.app01.api.barrier;

import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        //CyclicBarrier barrier = new CyclicBarrier(5);
        CyclicBarrier barrier = new CyclicBarrier(5, new BarrierPassing());
        Thread[] data = new MyThread3[5];
        for(int i=0;i<4;i++){
            data[i] = new MyThread3(barrier);
            data[i].start();
        }

        Thread.sleep(10000);
        data[4] = new MyThread3(barrier);
        data[4].start();

    }
}
