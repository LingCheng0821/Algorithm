/**
 * File��testForkJoin.java
 * Package��com.fang.forkjoin
 * Author��chengling
 * Date��2017��10��30�� ����10:34:47
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
 */
package com.fang.forkjoin;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;


/**
 * @author chengling
 */
public class CountTask extends RecursiveTask<Long>{

    int[] valueNum = new int[1000000];//1000w����
    
    //��ֵ
    private static final int THRESHOLD = 10000;
    //��ʼֵ
    private int start;
    //����ֵ
    private int end;

    public CountTask(int start, int end) {
        Random r = new Random();
        for(int i=start;i<end;i++){
            valueNum[i] = r.nextInt(10);
        }
        this.start = start;
        this.end = end;
    }


    @Override
    protected Long compute() {
        boolean compute = (end - start) <= THRESHOLD;
        Long res = 0L;
        if (compute){
            for (int i = start; i < end; i++){
              res += valueNum[i];
            }
        }else {
            //������ȴ�����ֵ����ָ�ΪС����
            int mid = (start + end) / 2;
            CountTask task1 = new CountTask(start,mid);
            CountTask task2 = new CountTask(mid + 1, end);
            //����С�����ֵ
            task1.fork();
            task2.fork();
            //�õ�����С�����ֵ
            Long task1Res = task1.join();
            Long task2Res = task2.join();
            res = task1Res + task2Res;
        }
        return res;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        long start = System.currentTimeMillis();
//        ForkJoinPool pool = new ForkJoinPool();
//       
//        CountTask task = new CountTask(1,1000000);
//        ForkJoinTask<Long> submit = pool.submit(task);
//        System.out.println("Final result:" + submit.get());
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
      Random r = new Random();
      System.out.println(r.nextInt());
    }
}

