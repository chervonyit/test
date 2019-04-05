package com.app.сh16.queue;

public interface MyQueue {

    public boolean isEmpty();

    public int size();

    public void enqueue(Object item);

    public Object dequeue();
}
