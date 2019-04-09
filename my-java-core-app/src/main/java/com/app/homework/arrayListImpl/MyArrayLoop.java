package com.app.homework.arrayListImpl;

public class MyArrayLoop implements MyList {

    private int n;
    private int capacity;
    private Object[] data;

    public MyArrayLoop(int capacity) {
        this.capacity = capacity;
    }

    public MyArrayLoop() {
        this(10);
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public void add(Object item) {
        if (n + 1 > data.length) {
            Object[] tmp = new Object[data.length + capacity];
            for (int i = 0; i < data.length; i++) {
                tmp[i] = data[i];
            }
            data = tmp;
        }
        data[n] = item;
        n++;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < n - 1; i++) {
            data[i] = data[i + 1];
        }
        data[n - 1] = null;
        n--;
    }

    @Override
    public Object set(int index, Object item) {
        Object oldValue = data[index];
        data[index] = item;
        return oldValue;
    }

    @Override
    public Object get(int index) {
        return data[index];
    }

    @Override
    public void clear() {
        data = new Object[data.length];
        n = 0;
    }
}
