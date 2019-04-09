package com.app.сh16.arraylist;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyArrayListImpl implements MyList {
    private Object[] data;
    private int n;
    private int capacity;
    private long version;

    public MyArrayListImpl(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    public MyArrayListImpl() {
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
        version++;
        if (n + 1 > data.length) {
            data = Arrays.copyOf(data, data.length + capacity);
        }
        data[n++] = item;
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
    public void remove(int index) {
        version++;
        for (int i = index; i < n - 1; i++) {
            data[i] = data[i + 1];
        }
        data[n - 1] = null;
        n--;
    }

    @Override
    public void clear() {
        data = new Object[data.length];
        n = 0;
    }




    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index;
            private long itrVersion = version;

            @Override
            public boolean hasNext() {
                return index < n;
            }

            @Override
            public Object next() {
                if (itrVersion != version) {
                    throw new ConcurrentModificationException();
                }
                Object res = get(index);
                index++;
                return res;
            }

            @Override
            public void remove() {
                MyArrayListImpl.this.remove(index - 1);
            }
        };
    }
}
