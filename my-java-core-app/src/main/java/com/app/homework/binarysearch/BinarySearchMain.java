package com.app.homework.binarysearch;

public class BinarySearchMain {

    public static void main(String[] args) {
        IntegerDataSearch integerDataSearch = new IntegerDataSearch();

        int[] data = {1,2,3,4,5,6,7};

        int value = integerDataSearch.search(data, 7);
        System.out.println("searched value = " + value);

        System.out.println("------------------------------");
        BinarySearch3 binarySearch3 = new BinarySearch3();
        int value1 = binarySearch3.search(data, 7);
        System.out.println("value = " + value1);

    }
}
