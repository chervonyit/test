package com.app.concurrency.app01.api.semaphore;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for(int i=0;i<4;i++){
            new MyThreadA1(semaphore, "Name"+i).start();;
        }
    }
}
