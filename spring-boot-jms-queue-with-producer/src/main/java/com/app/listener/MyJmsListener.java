package com.app.listener;

import javax.jms.Message;
import javax.jms.MessageListener;

public class MyJmsListener implements MessageListener {

    public void onMessage(Message message) {
        try {
            Thread.sleep(10000);
            System.out.println(message);
            //message.getIntProperty("age");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
