package com.app.concurrency.app01.vola;

public class ChangeMaker extends Thread {
    private CommonData commonData;

    public ChangeMaker(CommonData commonData) {
        this.commonData = commonData;
    }

    public void run(){
        //int localValue = commonData.getValue();
        while(commonData.getValue()<5){
          //  localValue++;
            commonData.setValue(commonData.getValue()+1);
            System.out.println("Produced: "+commonData.getValue());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------ChangeMaker Finish---------");
    }

    /*public void run(){
        int localValue = commonData.getValue();
        while(localValue<5){
            localValue++;
            commonData.setValue(localValue);
            System.out.println("Produced: "+localValue);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("--------ChangeMaker Finish---------");
    }*/
}
