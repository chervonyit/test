package com.app.сh16.bag;

import java.util.Arrays;

public class MyBagImpl implements MyBag {
    private Object[] data;
    private int n;
    private int capacity;

    public MyBagImpl(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyBagImpl() {
        this(10);
    }


    @Override
    public void add(Object item) {
        if(n+1>data.length){
            /*Object[] tmp = new Object[data.length+capacity];
            for(int i=0;i<data.length;i++){
                tmp[i] = data[i];
            }
            data = tmp;*/


            /*Object[] tmp = new Object[data.length+capacity];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;*/

            data = Arrays.copyOf(data, data.length+capacity);

        }
        data[n]=item;
        n++;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public int size() {
        return n;
    }
}
