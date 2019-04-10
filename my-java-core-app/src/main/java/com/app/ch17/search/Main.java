package com.app.ch17.search;

public class Main {

    public static void main(String[] args) {
        int[] data = {3,5,1,2,0,4,7,6,9,8};
        Searcher searcher = new LinearSearcher();
        int res=searcher.search(data, 4);
        System.out.println(res);
        res=searcher.search(data, 0);
        System.out.println(res);
        res=searcher.search(data, 7);
        System.out.println(res);
        res=searcher.search(data, 3);
        System.out.println(res);
        res=searcher.search(data, 8);
        System.out.println(res);
        System.out.println("---------------");
        System.out.println("-------------Binary Searcher----------------");
        data = new int[]{0,1,2,3,4,5,6,7,8,9};
        searcher = new LinearSearcher();
        res=searcher.search(data, 0);
        System.out.println(res);
        res=searcher.search(data, 9);
        System.out.println(res);
        res=searcher.search(data, 4);
        System.out.println(res);
        res=searcher.search(data, 5);
        System.out.println(res);
        res=searcher.search(data, 6);
        System.out.println(res);
        System.out.println("--------------------");
        data = new int[]{0,1,2,3,4,5,6,7,8,9, 10};
        searcher = new LinearSearcher();
        res=searcher.search(data, 0);
        System.out.println(res);
        res=searcher.search(data, 9);
        System.out.println(res);
        res=searcher.search(data, 4);
        System.out.println(res);
        res=searcher.search(data, 5);
        System.out.println(res);
        res=searcher.search(data, 6);
        System.out.println(res);
        res=searcher.search(data, 10);
        System.out.println(res);




    }
}
