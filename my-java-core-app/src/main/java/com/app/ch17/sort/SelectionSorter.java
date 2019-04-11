package com.app.ch17.sort;

public class SelectionSorter implements Sorter {

    @Override
    public void sort(int[] data) {
        for(int i=0;i<data.length-1;i++){
            int min = data[i];
            int minIndex = i;
            for(int j=i;j<data.length;j++){
                if(data[j]<min){
                    min = data[j];
                    minIndex = j;
                }
            }
            if(minIndex!=i){
                int tmp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = tmp;
            }
        }
    }
}
