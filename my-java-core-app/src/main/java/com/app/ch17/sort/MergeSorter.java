package com.app.ch17.sort;

public class MergeSorter implements Sorter {

    @Override
    public void sort(int[] data) {
            merge(data);
    }

    private int[] merge(int[] data){
        if(data.length<=1){
            return data;
        }

        int[] leftArray = new int[data.length/2];
        int[] rightArray = new int[data.length-leftArray.length];

        System.arraycopy(data, 0, leftArray, 0, leftArray.length);
        System.arraycopy(data, leftArray.length, rightArray, 0, rightArray.length);

        leftArray = merge(leftArray);
        rightArray = merge(rightArray);

        merge(leftArray, rightArray, data);

        return data;
    }

    /*
    [1,6,8,2,9,0]

    [1,6,8]
        [1,6] [8]
            [1] [6]   ;  [8]

                    [1,6]
                    [1,6]  [8]
                    [1,6,8]

    [2,9,0]
        [2,9] [0]
            [2] [9]   ;  [0]
                     [2,9]
                     [2,9]  [0]
                     [0,2,9]

       [1,6,8] ;  [0,2,9] --> [0,1,2,6,8,9]





    [1]   [2]

    [1,2]



    [0,1,4,7]    [2,5,8,9]

    [0,1,2,4,5,7,8,9]




     */
    private void merge(int[] leftArray, int[] rightArray, int[] data){
        int resultIndex = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while(leftIndex<leftArray.length && rightIndex<rightArray.length){
            int a = leftArray[leftIndex];
            int b = rightArray[rightIndex];
            if(a<=b){
                data[resultIndex] = a;
                leftIndex++;
            }else{
                data[resultIndex] = b;
                rightIndex++;
            }
            resultIndex++;
        }
        System.arraycopy(leftArray, leftIndex, data, resultIndex, leftArray.length-leftIndex);
        System.arraycopy(rightArray, rightIndex, data, resultIndex, rightArray.length-rightIndex);
    }


}
