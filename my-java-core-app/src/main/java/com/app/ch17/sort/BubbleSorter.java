package com.app.ch17.sort;

public class BubbleSorter implements Sorter {

    //0(N^2)
    @Override
    public void sort(int[] data) {
        for(int i=0;i<data.length-1;i++){
            for(int j=i;j<data.length;j++) {
                if (data[i] > data[j]) {
       //             swap(i, j, data);
                     swap2(i, j, data);
                }
            }
        }
    }

    private void swap(int i, int j, int[] data){
        int tmp = data[i];
        data[i]=data[j];
        data[j]=tmp;
    }


    /*
    a=a
    b=b

    a = a+b;
    b=b;

    a = a+b;
    b = a-b --> a - (a-b)--> a

    a=a+b
    b=a

    a = a+b-b --> a+b-(a)->b
    b=a;

    a=b;
    b=a;

     */

    /*
    a = a+b;
    b = a -b;
    a = a-b;
*/

    private void swap2(int i, int j, int[] data){
        data[i] = data[i]+data[j];
        data[j] = data[i]-data[j];
        data[i] = data[i]-data[j];
    }
}
