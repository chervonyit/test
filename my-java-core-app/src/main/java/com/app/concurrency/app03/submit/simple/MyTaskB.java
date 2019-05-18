package com.app.concurrency.app03.submit.simple;

import java.util.concurrent.Callable;

public class MyTaskB implements Callable {
    private String name;

    public MyTaskB(String name) {
        this.name = name;
    }

    @Override
    public Object call() throws Exception {
        Thread.sleep(4000);
        System.out.println(name);
        return null;
    }
}
