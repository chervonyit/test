package com.app.concurrency.app03.submit.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new MyTaskB("taskB"));

        executorService.shutdown();
    }
}
