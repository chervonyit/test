package com.app.ch17.sort;

public class InsertionSorter implements Sorter {


    @Override
    public void sort(int[] data) {
        for(int i=0;i<data.length-1;i++){
            int j =i+1;
            while(j>0 && data[j]<data[j-1]){
                int tmp = data[j];
                data[j]=data[j-1];
                data[j-1] = tmp;
                j--;
            }
        }
    }
}
