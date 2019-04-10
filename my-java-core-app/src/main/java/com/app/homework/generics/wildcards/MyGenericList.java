package com.app.homework.generics.wildcards;

import java.util.Arrays;
import java.util.Iterator;

public class MyGenericList<T> implements IMyGenericList<T> {

    private int n;
    private int capacity;
    private T[] data;
    private int version;

    public MyGenericList(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public MyGenericList() {
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
    public void add(T item) {
        if (n + 1 > data.length) {
            data = Arrays.copyOf(data, data.length + capacity);
        }
        data[n++] = item;
    }

    @Override
    public T set(int index, T item) {
        T oldValue = data[index];
        data[index] = item;
        return oldValue;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i < n - 1; i++) {
            data[i] = data[i+1];
        }
        data[n-1] = null;
        n--;
    }

    @Override
    public T get(int index) {
        return data[index];
    }

    @Override
    public void clear() {
        data = (T[]) new Object[data.length];
        n = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
