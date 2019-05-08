package com.app.concurrency.app01.thread.synchron;

public class DataThread extends Thread {

    private DataProcessor dataProcessor;

    public DataThread(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }

    public void run(){
        dataProcessor.write(1);
    }
}
