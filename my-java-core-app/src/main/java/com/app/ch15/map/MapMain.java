package com.app.ch15.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
                        Map
               HashMap   TreeMap    LinkedHashMap


 */
public class MapMain {

    public static void main(String[] args) {
        System.out.println("-------------HashMap--------------");
        Map map = new HashMap();
        Object oldValueByKey = map.put("A", "a");
        System.out.println("oldValueByKey="+oldValueByKey);
        oldValueByKey = map.put("A", "a1");
        System.out.println("oldValueByKey="+oldValueByKey);
        System.out.println(map);

        Object value=map.get("A");
        System.out.println(value);

        boolean contanis = map.containsKey("b");
        System.out.println("contains="+contanis);

        int n=map.size();
        boolean isEmpty = map.isEmpty();
        System.out.println("size="+n);
        System.out.println("isEmpty="+isEmpty);

        Object valueByKey=map.remove("b");
        System.out.println("valueByKey="+valueByKey);

        map.remove("A", "a1");
        System.out.println(map);

        System.out.println("----------map iterator--------------------");
        map.put(1, "a");
        map.put(2, "B");
        map.put(3, "C");

        Set keys = map.keySet();
        for(Object key: keys){
            Object currentValue=map.get(key);
            System.out.println(String.format("%s=%s",key, value));
        }

        Set entrySet = map.entrySet();
        for(Object entry: entrySet){
            Map.Entry item = (Map.Entry) entry;
            Object key=item.getKey();
            Object val=item.getValue();
            System.out.println(String.format("%s=%s",key, val));
        }



    }

}
