package com.app.concurrency.app01.thread.groups;

public class GroupMain {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("G1");
        group.setDaemon(true);

        MyThreadA t1 = new MyThreadA(group, "t1");
        MyThreadA t2 = new MyThreadA(group, "t2");
        MyThreadA t3 = new MyThreadA(group, "t3");

        t1.start();
        t2.start();
        t3.start();
        //ChildA childA = new ChildA(1);
        System.out.println("--------END-------");
    }
}
