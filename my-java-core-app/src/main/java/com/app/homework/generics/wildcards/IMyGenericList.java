package com.app.homework.generics.wildcards;

public interface IMyGenericList<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    void add(T item);

    T set(int index, T item);

    void remove(int index);

    T get(int index);

    void clear();
}
