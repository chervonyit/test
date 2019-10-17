package com.app.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class MyJmsProducer {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sent(final String text){
        MessageCreator mc = new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(text);
                message.setIntProperty("age", 4);
                return message;
            }
        };
        jmsTemplate.send(mc);
    }

}
