package com.app.сh16.innerouter;

public class Main {

    public static void main(String[] args) {
        MyOuterClass myOuterClass = new MyOuterClass();

        MyOuterClass.MyInnerA myInnerA1 = myOuterClass. new MyInnerA();
        MyOuterClass.MyInnerA myInnerA2 = myOuterClass. new MyInnerA();
        MyOuterClass.MyInnerA myInnerA3 = myOuterClass. new MyInnerA();


        MyOuterClass.MyInnerA myInnerA4 = new MyOuterClass(). new MyInnerA();

        MyOuterClass.MyInnerStaticA myInnerStaticA1 = new MyOuterClass.MyInnerStaticA();
    }

}
