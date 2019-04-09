package com.app.homework.concurrentmodification;

import java.util.ArrayList;
import java.util.List;

public class ConcurrentModificationMain {

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        List<String> toRemove = new ArrayList<String>();

        a.add("1");
        a.add("2");

        // ConcurrentModificationException will be thrown here
        for(String s : a){
            if(s.equals("1")){
                a.add("some value");
            }
        }

        for(String s : a){
            if(s.equals("1")){
                toRemove.add(s);
            }
        }

        a.removeAll(toRemove);
        System.out.println(a);


    }
}
