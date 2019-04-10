package com.app.сh16.map;

import java.util.LinkedList;

public class MyHashMapImpl<K, V> implements MyHashMap<K, V> {
    private LinkedList<Entry<K, V>>[] backets;
    private int capacity;
    private int n;
    //n/backets.length;


    public MyHashMapImpl(int capacity) {
        this.capacity = capacity;
        backets = new LinkedList[capacity];
    }

    public MyHashMapImpl() {
        this(10);
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public V put(K key, V value) {
        int index = key.hashCode() % backets.length;
        LinkedList<Entry<K, V>> backet = backets[index];
        for (Entry<K, V> entry : backet) {
            if (entry.key.equals(key)) {
                V oldValue = entry.value;
                entry.value = value;
                entry.key = key;
                return oldValue;
            }
        }
        backet.add(new Entry(key, value));
        n++;
        return null;
    }

    @Override
    public V get(K key) {
        int index = key.hashCode() % backets.length;
        LinkedList<Entry<K, V>> backet = backets[index];
        for (Entry<K, V> entry : backet) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public void remove(K key) {
        int index = key.hashCode() % backets.length;
        LinkedList<Entry<K, V>> backet = backets[index];
        for (Entry<K, V> entry : backet) {
            if (entry.value.equals(key)) {
                backet.remove(entry);
                n--;
                return;
            }
        }
    }

    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            value = value;
        }
    }
}
