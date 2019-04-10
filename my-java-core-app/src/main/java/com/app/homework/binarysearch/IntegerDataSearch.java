package com.app.homework.binarysearch;

public class IntegerDataSearch implements Searcher {


    @Override
    public int search(int[] data, int target) {
        // take left part of the array that is equals 0
        int left = 0;
        // take right part of the array that is equals data.length
        int right = data.length;

        // looping until left part < right part
        while (left < right) {
            // finding middle of the array
            int middle = (left + right) / 2;

            // checking if target == value in the middle of array
            if (target == data[middle]) {
                return middle;
            }

            if (target < data[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
