package com.app;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class MyService {

    @Async
    public void doAction(){
        System.out.println("START.doAction()");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish.doAction()");
    }


    @Async
    public Future<String> doAction2(){
        System.out.println("START.doAction2()");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish.doAction2()");
        return new AsyncResult<String>("Hello!!!");
    }


}
