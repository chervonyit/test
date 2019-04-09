package com.app.сh16.genericsample;

public class MyDataChild extends MyDataParent {

    @Override
    public MyDataChild getResult() {
        return new MyDataChild();
    }

    public String[] getData(){
        return new String[10];
    }
}
