package com.app.homework.binarysearch;

public class BinarySearch1 implements Searcher {


    @Override
    public int search(int[] data, int target) {
        int left = 0;
        int right = data.length;

        while(left < right){
            int middle = (left + right)/2;

            if(target == data[middle]){
                return middle;
            }

            if(target < data[middle]){
                right = middle -1;
            } else {
                left = middle +1;
            }
        }
        return -1;
    }
}
