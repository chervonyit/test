package com.app.сh16.linkedlist;

import com.app.сh16.arraylist.MyList;

public class MyLinkedListImpl implements MyList {
    private Node root;
    private int n;


    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public void add(Object item) {
        Node current = new Node(item);
        if(root==null){
            root = current;
            n++;
            return;
        }
        Node tmp = root;
        while(tmp.getNext()!=null){
            tmp=tmp.getNext();
        }
        tmp.setNext(current);
        current.setPrev(tmp);
        n++;
    }

    @Override
    public Object set(int index, Object item) {
        int i=0;
        Node tmp = root;
        while(tmp.getNext()!=null){
            if(i==index){
                break;
            }
            tmp=tmp.getNext();
            i++;
        }
        Object oldValue = tmp.getValue();
        tmp.setValue(item);
        return oldValue;
    }

    @Override
    public Object get(int index) {
        int i=0;
        Node tmp = root;
        while(tmp.getNext()!=null){
            if(i==index){
                break;
            }
            tmp=tmp.getNext();
            i++;
        }
        return tmp.getValue();
    }

    @Override
    public void remove(int index) {
        int i=0;
        Node tmp = root;
        while(tmp.getNext()!=null){
            if(i==index){
                break;
            }
            tmp=tmp.getNext();
            i++;
        }

        Node prev = tmp.getPrev();
        Node next = tmp.getNext();

        if(prev==null){
            if(next==null){
                root = null;
                n--;
                return;
            }
            root = next;
            next.setPrev(null);
            n--;
            return;
        }


        if(next==null){
            prev.setNext(null);
            n--;
            return;
        }

        /* a-->b-->c
           a<--b<--c
           a<-->c
        */


        prev.setNext(next);
        next.setPrev(prev);
        n--;

    }

    @Override
    public void clear() {
        root=null;
        n=0;
    }
}
