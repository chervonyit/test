package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.Message;
import javax.jms.MessageListener;

public class MyListener implements MessageListener {

    public void onMessage(Message message) {
        System.out.println("Start Listener! "+hashCode());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("\t"+message);
        System.out.println("End Listener! "+hashCode());
    }
}
