package com.app.concurrency.app03.submit.sum;

import java.util.concurrent.Callable;

public class SubTask implements Callable<Integer> {
    private int[] data;
    private int start;
    private int end;

    public SubTask(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() {
        System.out.println("Started call: start="+start);
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += data[i];
            pause();
        }
        return sum;
    }

    private void pause(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
