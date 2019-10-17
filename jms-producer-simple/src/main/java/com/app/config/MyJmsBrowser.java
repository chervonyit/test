package com.app.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

import javax.jms.*;
import java.util.Enumeration;

public class MyJmsBrowser {

    private ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    private ActiveMQQueue destination = new ActiveMQQueue("saturdayQueue");

    public void browse(){
        Connection connection = null;
        try {
            connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            QueueBrowser queueBrowser = session.createBrowser(destination);
            Enumeration enumeration = queueBrowser.getEnumeration();

            while(enumeration.hasMoreElements()){
                Object item = enumeration.nextElement();
                System.out.println(item);
            }
            System.out.println("--------------------");
            Queue queue = queueBrowser.getQueue();
            System.out.println(queue);



            /*MessageProducer mp = session.createProducer(destination);
            TextMessage msg = session.createTextMessage(txt);
            mp.send(msg);*/
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
