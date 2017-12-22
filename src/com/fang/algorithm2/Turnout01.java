package com.fang.algorithm2;

import java.util.Scanner;

/**
 * 初始有A个0,B个1，目标是把所有的值都变为1，每次操作可以任意选择恰好K个数字，并将这K个数字的值进行翻转(0变为1，1变为0)。
 * 牛牛如果使用最少的操作次数完成这个游戏就可以获得奖品，牛牛想知道最少的操作次数是多少？
 * 例如:A = 4 B = 0 K = 3
 * 0000 -> 1110 -> 1001 -> 0100 -> 1111 需要的最少操作次数为4
 *
 * 输入描述: 输入为一行： 一共三个整数A(0 ≤ A ≤ 100,000),B(0 ≤ B ≤ 100,000),K(1 ≤ K ≤100,000).以空格分隔
 *
 * 输出描述:输出一个整数，表示最少需要的操作次数。如果不能完成，则输出-1
 * 分析：
 *  设 n = A+B  设 位置值序列集合 E = {e1, e2, e3,... en}， ei ∈ {0, 1}，其中ei表示第i个位置上的值 （1 ≤ i ≤ n）
 *  因为一次翻转必翻转K个位置，假设进行了X次翻转（未知数），则有以下等式 ① XK = ∑Ti （1 ≤ i ≤ n）
 *  为了使所有位置均为1， Ti 必满足以下条件：
 *  ② Ti = 1 + 2Si （ei 初始为0）  ③ Ti = 2Si（ei 初始为1）
 *  其中Si 表示第i个位置进行了 Si次2次翻转
 *  结合①、②、③可得： ④ XK = A + 2 ∑Si （1 ≤ i ≤ n）  ⑤ XK - A 必为偶数
 *  对于初始为1的位置，2次翻转次数不能超过X/2
 *  对于初始为0的位置，2次翻转次数不能超过(X-1)/2 ，因为最后一次翻转不能属于“2次翻转”中的一次翻转
 *  则 ⑥ (XK - A)/2 = ∑Si （1 ≤ i ≤ n）≤ A ((X-1)/2) + B(X/2)
 * Created by Laura on 2017/11/27.
 */
public class Turnout01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int K = sc.nextInt();
        sc.close();
        System.out.println(function(A,B,K));


    }

/*    public static int function(int A, int B, int K){
        //参数错误
        if(A < 0 || A > 100000 || B < 0 || B > 100000 || K < 1 || K > 100000)
            return -1;
        if (A == 0) return 0;   //没有0的数据


        int remainder = A % K;  //直接翻转后的剩余待翻转个数
        int count = A / K;      //直接翻转
        int S = A + B;//总个数


        if(remainder == 0){ //可以直接翻转得到,翻转次数为 A / K
            return count;
        }
        else if (S <= K ) //无法翻成功的输出-1
            count = -1;
        else if(remainder % 2 == 1 && K % 2 == 0 ) // remainder为奇数，需要翻动奇数次，积为奇数，K为偶数
            count = -1;
        *//**
         * K - remainder : 假设 remainder个0需要转一次，再加上K-remainder的偶数次
         *
         *//*
        else if ((K - remainder) % 2 == 0 && count > 0 && B + K * count >= 2 * K - (remainder + K) / 2)
            count++;//一种特殊情况，还剩下K+remainder个0时直接翻两次即可完成
        else if (remainder % 2 == 0)
            count += 2 * Math.ceil(((double)remainder / (2 * (S - K))));
        //每翻两次最多能把remainder中的2*(S-K)个0翻成1，注意这里指的是最多，当翻最后2次或者S-K>remainder/2时，只需翻两次，所以这里用到了ceil（）
        else
            count += 2 * Math.ceil((double)(K - remainder) / (2 * (S - K))) + 1;
            //当remainder是奇数时，相当于先把所有1中的K-remainder个翻成0，这样加上remainder一共K个0，
            // 只需额外再翻一次即可，K-remainder是奇数时，永远不能翻成功，是偶数时，翻转方法同上面
        return count;
    }*/

    public static int function(int A, int B, int K){
        int remainder = A % K;          //直接翻转后的剩余待翻转个数,即剩余0的个数
        int count = A / K;              //直接翻转的次数
        B += A - remainder;             //直接翻转后1的个数

        /**
         * 情况1：直接翻转可得结果
         */
        if (A == 0 || remainder == 0)    return count;

        /**
         * 情况2：remainder＋Ｂ＜＝Ｋ　每次翻转的次数大于总数量
         *       remainder为奇数，需要翻动奇数次，积为奇数，K为偶数　
         *       K=偶数 无解 无论如何总会单一个
         *       不满足要求
         */
        else if ((remainder + B <= K) || (remainder % 2 == 1 && K % 2 == 0))
            count = -1;

        /**
         * 情况3：一种特殊情况，还剩下K+remainder个0时直接翻一次即可完成
         */
        else if ((K + remainder) % 2 == 0 && count > 0 && B >= 2 * K - (remainder + K) / 2)
            count++;
        /**
         * remainder=偶数
            好巧,两次搞定,挑一半(remainder/2)个0,外加(K-remainder)/2个1,翻第1次,剩下的刚好K个0

         每翻两次最多能把remainder中的2*(S-K)个0翻成1，注意这里指的是最多，当翻最后2次或者S-K>remainder/2时，只需翻两次，所以这里用到了ceil（）
         */
        else if (remainder % 2 == 0)
            count += 2 * Math.ceil((double)remainder / (2 * (B - K + remainder)));

        /**
         * 链接：https://www.nowcoder.com/questionTerminal/9c4c9d10e3db4448b906c6e6cea22b7f
         来源：牛客网

          //当remainder是奇数时，相当于先把所有1中的K-remainder个翻成0，这样加上remainder一共K个0，只需额外再翻一次即可，K-remainder是奇数时，永远不能翻成功，是偶数时，翻转方法同上面
         */
        else
            count += 2 * Math.ceil((double)(K - remainder) / (2 * (B - K + remainder))) + 1;

        return count;
    }
}

