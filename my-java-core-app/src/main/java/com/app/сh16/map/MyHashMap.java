package com.app.сh16.map;

public interface MyHashMap<K,V> {

    public boolean isEmpty();

    public int size();

    public V put(K key, V value);

    public V get(K key);

    public void remove(K key);
}
