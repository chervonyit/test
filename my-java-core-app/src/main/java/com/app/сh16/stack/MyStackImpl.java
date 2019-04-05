package com.app.сh16.stack;

import java.util.Arrays;

public class MyStackImpl implements MyStack {
    private Object[] data;
    private int n;
    private int capacity;

    public MyStackImpl(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyStackImpl() {
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
    public void push(Object item) {
        if(n+1>data.length){
            data = Arrays.copyOf(data, data.length+capacity);
        }
        data[n++]=item;
    }

    @Override
    public Object peek() {
        return data[n-1];
    }

    /*
    [1,2,3,4,5,6]
    6 - [1,2,3,4,5, null]
    5 - [1,2,3,4,null, null]
    4 - [1,2,3,null,null, null]
     */

    @Override
    public Object poll() {
        Object value = data[n-1];
        data[n-1] = null;
        n--;
        return value;
    }
}
