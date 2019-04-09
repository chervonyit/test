package com.app.сh16.concurrentmodification;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List list = new ArrayList();

        list.add("A");
        list.add("AB");
        list.add("C");
        list.add("d");
        list.add("e");

        /*
        fail fast iterator
         */

        /*for(Object item: list){
            if("C".equals(item)){
                list.add("Test");
            }
        }*/


        Iterator itr = list.iterator();
        itr.next();
        itr.remove();
    }
}
