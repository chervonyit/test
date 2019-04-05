package com.app.ch15.set;


import java.util.*;

/*
1) no order
2) uniqueue
3) no index access


 */
public class Main {

    public static void main(String[] args) {
        System.out.println("--------HashSet--------------");
        Set set = new HashSet();

        set.add("A");
        set.add("b");
        set.add("c");
        set.add("d");

        System.out.println(set);
        System.out.println(set.size());
        set.add("A");
        set.add("A");
        set.add("A");
        System.out.println(set);
        System.out.println(set.size());

        Iterator itr = set.iterator();
        while(itr.hasNext()){
            Object item = itr.next();
            System.out.println(item);
        }
        System.out.println("---------------------");
        for(Object item: set){
            System.out.println(item);
        }

        System.out.println("------------TreeSet-----------------");
        set = new TreeSet();
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("A");
        set.add("A");
        System.out.println(set);
        System.out.println("-----------------------------");
        for(Object item: set){
            System.out.println(item);
        }

        /*set.add(new Object());
        for(Object item: set){
            System.out.println(item);
        }*/


        System.out.println("---------LinkedHashSet---------------------");
        set = new LinkedHashSet();
        set.add("A");
        set.add(1);
        set.add(new Object());
        for(Object item: set){
            System.out.println(item);
        }
    }
}
