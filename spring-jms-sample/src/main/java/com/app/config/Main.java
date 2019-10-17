package com.app.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
       // ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        MyJmsProducer producer = new MyJmsProducer();
        producer.sendData("test");

    }
}
