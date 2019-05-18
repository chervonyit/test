package com.app.concurrency.app03.execute;

public class MyTaskA implements Runnable {
    private String name;

    public MyTaskA(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++) {
            System.out.println(name);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
