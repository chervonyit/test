package com.app.concurrency.app03.submit.sum;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int n = 5;
        int step = data.length/n;
        ExecutorService executorService = Executors.newFixedThreadPool(n);
        /*for(int i=0;i<n-step;i=i+step){
            executorService.submit(new SubTask(data, i, i+step));
        }*/

        Future<Integer> result1 =  executorService.submit(new SubTask(data, 0,2));
        //int subSum = result1.get();
        //System.out.println("subTask="+subSum);
        Future<Integer> result2 = executorService.submit(new SubTask(data, 2,4));
        Future<Integer> result3 = executorService.submit(new SubTask(data, 4,6));
        Future<Integer> result4 = executorService.submit(new SubTask(data, 6,8));
        Future<Integer> result5 = executorService.submit(new SubTask(data, 8,10));

        Future<Integer>[] futureData = new Future[5];
        futureData[0] = result1;
        futureData[1] = result2;
        futureData[2] = result3;
        futureData[3] = result4;
        futureData[4] = result5;


        int sum = 0;
        for(Future<Integer> f: futureData){
            /*if(f.isDone()){
                f.get();
            }*/
            int subSum = f.get();
            System.out.println("subSum="+subSum);
            sum+=subSum;
        }
        System.out.println("sum="+sum);
        executorService.shutdown();
    }
}
