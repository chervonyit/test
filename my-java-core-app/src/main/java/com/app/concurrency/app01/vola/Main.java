package com.app.concurrency.app01.vola;

public class Main {

    public static void main(String[] args) {
        CommonData commonData = new CommonData();
        ChangeMaker changeMaker = new ChangeMaker(commonData);
        ChangeListener changeListener = new ChangeListener(commonData);
        changeMaker.start();
        changeListener.start();

    }
}
