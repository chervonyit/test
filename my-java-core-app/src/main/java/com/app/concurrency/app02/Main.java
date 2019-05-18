package com.app.concurrency.app02;

import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        TimerTask timerTask1 = new MyTask1();
        TimerTask timerTask2 = new MyTask2();

        timer.scheduleAtFixedRate(timerTask1, 0, 5000);
        timer.scheduleAtFixedRate(timerTask2, 0, 1000);
        //timer.cancel();

        Thread.sleep(10000);
        timerTask2.cancel();
    }

}
