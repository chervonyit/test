package com.app.job;

import com.app.producer.MyJmsProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    @Autowired
    private MyJmsProducer myJmsProducer;

    @Scheduled(fixedRate = 5000)
    public void doJob(){
        System.out.println("NotificationService.doJob()");
        myJmsProducer.sent("Message from producer!!!!");
    }
}
