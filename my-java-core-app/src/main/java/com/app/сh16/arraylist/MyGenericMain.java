package com.app.сh16.arraylist;

public class MyGenericMain {

    public static void main(String[] args) {
        MyGenericList myGenericList = new MyGenericArrayList();
        myGenericList.add("a");
        myGenericList.add(true);
        myGenericList.add(122);

        System.out.println(myGenericList);

        MyGenericList<String> myGenericList2 = new MyGenericArrayList();
        //myGenericList2.add(true);
        //myGenericList2.add(122);

        for(String s: myGenericList2){

        }



    }
}
