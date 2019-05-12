package com.app.concurrency.app01.blockingqueue.priority;

import java.util.concurrent.BlockingQueue;

public class MyQueueProducer extends Thread {

    private BlockingQueue blockingQueue;

    public MyQueueProducer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run(){
        MyData myData1 = new MyData("Added1", 0);
        MyData myData2 = new MyData("Added2", 1);
        MyData myData3 = new MyData("Added3", -5);
        MyData myData4 = new MyData("Added4", 6);
        MyData myData5 = new MyData("Added5", 2);
        MyData myData6 = new MyData("Added6", 3);
        MyData myData7 = new MyData("Added7", 4);
        MyData myData8 = new MyData("Added8", 5);
        MyData myData9 = new MyData("Added9", 6);
        MyData myData10 = new MyData("Added10", 7);
        MyData myData11 = new MyData("Added11", 8);
        MyData myData12 = new MyData("Added12", 9);
        try {
            blockingQueue.put(myData1);
            System.out.println("Produced: "+myData1);
            blockingQueue.put(myData2);
            System.out.println("Produced: "+myData2);
            blockingQueue.put(myData3);
            System.out.println("Produced: "+myData3);
            blockingQueue.put(myData4);
            System.out.println("Produced: "+myData4);
            blockingQueue.put(myData5);
            System.out.println("Produced: "+myData5);
            blockingQueue.put(myData6);
            System.out.println("Produced: "+myData6);
            blockingQueue.put(myData7);
            System.out.println("Produced: "+myData7);
            blockingQueue.put(myData8);
            System.out.println("Produced: "+myData8);
            blockingQueue.put(myData9);
            System.out.println("Produced: "+myData9);
            blockingQueue.put(myData10);
            System.out.println("Produced: "+myData10);
            blockingQueue.put(myData11);
            System.out.println("Produced: "+myData11);
            blockingQueue.put(myData12);
            System.out.println("Produced: "+myData12);
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
