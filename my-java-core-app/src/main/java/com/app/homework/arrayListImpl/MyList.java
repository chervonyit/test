package com.app.homework.arrayListImpl;

public interface MyList {

    int size();
    boolean isEmpty();
    void add(Object item);
    Object set(int index, Object item);
    void remove(int index);
    Object get(int index);
    void clear();
}
