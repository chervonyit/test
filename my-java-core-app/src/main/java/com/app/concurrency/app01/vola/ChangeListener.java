package com.app.concurrency.app01.vola;

public class ChangeListener extends Thread {
    private CommonData commonData;

    public ChangeListener(CommonData commonData) {
        this.commonData = commonData;
    }

    public void run(){
        int tmp = commonData.getValue();
        while(commonData.getValue()<5){
          //  System.out.println(tmp);

            if(tmp!=commonData.getValue()) {
                System.out.println("\tChange detected: " + commonData.getValue());
                tmp = commonData.getValue();
            }
            try {
                //Thread.sleep(10);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("-------ChangeListener Finish-----------");
    }


    /*public void run(){
        int localValue = commonData.getValue();
        while(localValue<5){
            if(localValue!=commonData.getValue()){
                System.out.println("\tChange detected: "+commonData.getValue());
                localValue=commonData.getValue();
            }
        }
        System.out.println("-------ChangeListener Finish-----------");
    }*/
}
