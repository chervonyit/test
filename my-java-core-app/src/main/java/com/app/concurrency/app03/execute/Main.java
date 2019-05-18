package com.app.concurrency.app03.execute;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {



    public static void main4(String[] args) {
        ScheduledExecutorService executorService =  Executors.newScheduledThreadPool(10);
        //for(int j=0;j<20;j++){
            executorService.schedule(new MyTaskA("Task"), 2, TimeUnit.SECONDS );
        //}
        executorService.shutdown();
    }

    public static void main3(String[] args) {
        ExecutorService executorService =  Executors.newCachedThreadPool();
        for(int j=0;j<20;j++){
            executorService.execute(new MyTaskA("Task"+j));
        }
        executorService.shutdown();

    }


    public static void main2(String[] args) {
        ExecutorService executorService =  Executors.newFixedThreadPool(10);
        for(int j=0;j<20;j++){
            executorService.execute(new MyTaskA("Task"+j));
        }

        /*executorService.shutdown();
        for(int j=20;j<40;j++){
            executorService.execute(new MyTaskA("Task"+j));
        }*/
        executorService.shutdownNow();

    }
}
