package com.app.сh16.genericsample;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String[] str = {"a","b","c"};
        Object[] str2 = {"a","b","c"};
        Object[] str3 = {"a", Boolean.valueOf("true"), 1};

        //str[0] = 1;

        List list = new ArrayList();
        list.add("A");
        list.add("B");
        list.add(1);


        List<String> stringList = new ArrayList<String>();
        stringList.add("adfas");
        addData(stringList);
        String res=stringList.get(1);
        System.out.println(res);

        List<Object> objectList = new ArrayList<Object>();
        List<Object> objectList2 = new ArrayList();
        List<Object> objectList3 = new ArrayList<>();


        List<MyDataParent> myDataParentList = new ArrayList<>();
        myDataParentList.add(new MyDataParent());
        myDataParentList.add(new MyDataChild());

        addData2(myDataParentList);
        addData(myDataParentList);
    }


    private static void addData(List list){
        list.add(20);
    }


    /*
    ? - wildcard
    producer - super // add
    consumer - extends // get
     */
    private static void addData2(List<? super MyDataParent> list){
        list.add(new MyDataChild());
        list.add(new MyDataParent());
        //list.add("");
        //MyDataParent res=list.get(1);
        //MyDataChild res2=list.get(1);
    }



    private static MyDataParent getData2(List<? extends MyDataParent> list){
        //list.get(1);
        MyDataParent parent = list.get(1);
        list.add(null);
        //list.add(new Object());
        return parent;
    }

}
