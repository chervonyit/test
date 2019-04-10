package com.app.сh16.arraylist;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class MyGenericArrayList<T>  implements MyGenericList<T> {
    private T[] data;
    private int n;
    private int capacity;
    private long version;

    public MyGenericArrayList(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public MyGenericArrayList() {
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
        version++;
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
    public T get(int index) {
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
        data = (T[]) new Object[data.length];
        n = 0;
    }

    public String toString(){
        Object[] tmp = Arrays.copyOfRange(data, 0, n);
        return Arrays.toString(tmp);
    }

    public int hashCode(){
        Object[] tmp = Arrays.copyOfRange(data, 0, n);
        return Arrays.hashCode(tmp);
    }

    public boolean equals(Object object){
        if(object==null){
            return false;
        }
        if(object==this){
            return true;
        }
        if(object.getClass() == getClass()){
            MyGenericList tmp = (MyGenericList) object;
            if(tmp.size()==size()){
                for(int i=0;i<size();i++){
                    Object a = tmp.get(i);
                    Object b = get(i);
                    if(a!=null && b!=null){
                        if(!a.equals(b)){
                            return false;
                        }
                        continue;
                    }
                    if(b==null && a==null){
                        continue;
                    }
                    return false;
                }
            }
        }
        return false;
    }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index;
            private long itrVersion = version;

            @Override
            public boolean hasNext() {
                return index < n;
            }

            @Override
            public T next() {
                if (itrVersion != version) {
                    throw new ConcurrentModificationException();
                }
                T res = get(index);
                index++;
                return res;
            }

            @Override
            public void remove() {
                MyGenericArrayList.this.remove(index-1);
            }
        };
    }
}
