package com.app.сh16.queue;

import java.util.Arrays;

public class MyQueueImpl implements MyQueue {
    private Object[] data;
    private int capacity;
    private int n;

    public MyQueueImpl(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyQueueImpl() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public void enqueue(Object item) {
        //data[n]=item;
        //n++;
        if(n+1>data.length){
            data = Arrays.copyOf(data, data.length+capacity);
        }
        data[n++]=item;
    }

    /*
    [1,2,3,4,5,6]
        [2,2,3,4,5,6]
        [2,3,3,4,5,6]
        [2,3,4,4,5,6]
        [2,3,4,5,5,6]
        [2,3,4,5,6,6]
        [2,3,4,5,6,null]
     */

    @Override
    public Object dequeue() {
        Object headItem = data[0];
        for(int i=0;i<n-1;i++){
            data[i]=data[i+1];
        }
        data[n-1]=null;
        n--;
        return headItem;
    }
}
