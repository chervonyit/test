package com.app;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyTimerComponent {

    @Scheduled(cron = "*/10 * * * * *")
    public void doSomething(){
        System.out.println("doSomething()");
    }

    @Scheduled(fixedRate = 1000)
    public void doSomething2(){
        System.out.println("doSomething()2");
    }

}
