package com.app.ch17.search;

public class LinearSearcher implements Searcher {

    @Override
    public int search(int[] data, int target) {
        for(int i=0;i<data.length;i++){
            if(data[i]==target){
                return i;
            }
        }
        return -1;
    }
}
