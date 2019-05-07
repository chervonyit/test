package com.app.concurrency.app01.thread.homework.groups;

import com.app.concurrency.app01.thread.homework.BadIncrement;
import com.app.concurrency.app01.thread.homework.MyDataThread;

public class MainGroups {

    BadIncrement badIncrement = new BadIncrement();
    ThreadGroup g1 = new ThreadGroup("G1");

    MyDataThread t1 = new MyDataThread(g1, "t1", badIncrement);
    MyDataThread t2 = new MyDataThread(g1, "t2", badIncrement);
    MyDataThread t3 = new MyDataThread(g1, "t3", badIncrement);



}
