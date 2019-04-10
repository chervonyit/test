package com.app.homework.binarysearch;

public class BinarySearch2 implements Searcher {


    @Override
    public int search(int[] data, int target) {
        int start = 0;
        int end = data.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == data[mid]) {
                return mid;
            }

            if (target < data[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
