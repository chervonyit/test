package com.app.homework.binarysearch;

public class BinarySearchMain {

    public static void main(String[] args) {
        IntegerDataSearch integerDataSearch = new IntegerDataSearch();

        int[] data = {1,2,3,4,5,6,7};

        int value = integerDataSearch.search(data, 7);
        System.out.println("searched value = " + value);

        System.out.println("------------------------------");
        BinarySearch2 binarySearch2 = new BinarySearch2();
        int value1 = binarySearch2.search(data, 5);
        System.out.println("value = " + value1);

    }
}
