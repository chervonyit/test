package com.app.ch17.search;

public class BinarySearcher implements Searcher {

    @Override
    public int search(int[] data, int target) {
        int left = 0;
        int right = data.length;
        while(left<right) {
            int middle = (left+right)/2;

            if (data[middle] == target) {
                return middle;
            }

            if (target < data[middle]) {
                right = middle-1;
            } else {
                left=middle+1;
            }
        }
        return -1;
    }
}
