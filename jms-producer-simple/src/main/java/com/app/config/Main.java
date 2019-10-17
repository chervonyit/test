package com.app.config;

public class Main {

    public static void main(String[] args) {
        MyJmsProducer myJmsProducer = new MyJmsProducer();
        //myJmsProducer.sendData("qqqqq");
        MyJmsBrowser browser = new MyJmsBrowser();
        browser.browse();
    }
}
