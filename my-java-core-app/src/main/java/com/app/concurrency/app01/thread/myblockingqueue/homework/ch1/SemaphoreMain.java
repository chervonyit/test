package com.app.concurrency.app01.thread.myblockingqueue.homework.ch1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class SemaphoreMain {

    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(2, true);

        List<Thread> threads = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            SemaphoreDemo semaphoreDemo = new SemaphoreDemo(semaphore);
            semaphoreDemo.start();
            threads.add(semaphoreDemo);
        }

        Thread.sleep(20000);
        for(Thread t : threads){
            t.interrupt();
        }
    }

    private static class SemaphoreDemo extends Thread {
        private final Semaphore semaphore;

        private SemaphoreDemo(Semaphore semaphore){
            this.semaphore = semaphore;
        }

        @Override
        public void run(){
            try {
                runUnsafe();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void runUnsafe() throws InterruptedException {
            for(;;){
                semaphore.acquire();
                try{
                    System.out.println("Semaphore acquired by thread = " + getName());
                    Thread.sleep(5000);
                } finally {
                    System.out.println("Semaphore releasing by thread " + getName());
                    semaphore.release();
                }
            }
        }
    }
}





