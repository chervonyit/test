package com.app.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;

public class MyJmsProducer {
    private ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    private Destination destination = new ActiveMQQueue("saturdayQueue");


    public void sendData(String txt){
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer mp = session.createProducer(destination);
            TextMessage msg = session.createTextMessage(txt);
            mp.send(msg);
        } catch (JMSException e) {
            e.printStackTrace();
        }finally{
            if(connection!=null){
                try {
                    connection.close();
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
