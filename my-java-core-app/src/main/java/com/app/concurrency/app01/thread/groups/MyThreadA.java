package com.app.concurrency.app01.thread.groups;

public class MyThreadA extends Thread {

    public MyThreadA(ThreadGroup group, String t1) {
        super(group, t1);
        setDaemon(group.isDaemon());
    }

    public void run(){
        System.out.println(getName()+"; "+getPriority());
        while(true){

        }
    }
}
