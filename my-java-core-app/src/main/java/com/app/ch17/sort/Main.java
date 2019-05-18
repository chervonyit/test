package com.app.ch17.sort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] data = {5,3,2,1};
        Sorter sorter = new BubbleSorter();
        //Sorter sorter = new SelectionSorter();
        //Sorter sorter = new InsertionSorter();
        //Sorter sorter = new MergeSorter();
        sorter.sort(data);
        System.out.println(Arrays.toString(data));


        System.out.println("-------Swap 2 numbers------------");
        int a = 1;
        int b = 2;

        a = a+b;
        b = a -b;
        a = a-b;

        System.out.println("a="+a);
        System.out.println("b="+b);
    }
}
