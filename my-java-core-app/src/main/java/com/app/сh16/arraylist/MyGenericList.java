package com.app.сh16.arraylist;

public interface MyGenericList<T> extends Iterable<T> {

    public int size();

    public boolean isEmpty();

    public void add(T item);

    public T set(int index, T item);

    public T get(int index);

    public void remove(int index);

    public void clear();
}
