package com.app.concurrency.app01.thread.synchron;

public class Main {

    public static void main(String[] args) {
        DataProcessor dataProcessor = new DataProcessor();
        DataThread dataThread1 = new DataThread(dataProcessor);
        DataThread dataThread2 = new DataThread(dataProcessor);
        dataThread1.start();
        dataThread2.start();
    }
}
