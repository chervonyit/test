package org.app.database.simple;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Dao dao = new DaoImpl();
        List<MyItem> list = init(10);
        System.out.println("---------CREATE---------");
        for(MyItem item: list){
            dao.create(item);
        }
        System.out.println("---------READ---------");
        list=dao.read();
        for(MyItem item: list){
            System.out.println(item);
        }
        System.out.println("---------UPDATE---------");

        MyItem cMyItem = new MyItem();
        cMyItem.setAge(0);
        cMyItem.setName("Name0");

        MyItem candidate = new MyItem();
        candidate.setAge(70);
        candidate.setName("Name70");
        dao.update(cMyItem, candidate);
        list=dao.read();
        for(MyItem item: list){
            System.out.println(item);
        }
        System.out.println("-----------DELETE-----------------");
        dao.delete(candidate);
        list=dao.read();
        for(MyItem item: list){
            System.out.println(item);
        }
        System.out.println("--------------METADATA-------------------");
        List<Map<String, Object>> resultList = dao.meatInf();
        for(Map<String, Object> map: resultList){
            System.out.println(map);
        }
    }

    private static List<MyItem> init(int n) {
        List<MyItem> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            MyItem myItem = new MyItem();
            myItem.setName("Name" + i);
            myItem.setAge(i);
            list.add(myItem);
        }
        return list;
    }
}
