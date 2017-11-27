package com.fang.algorithm2;

import java.util.Arrays;
import java.util.Scanner;

/**

 牛牛的好朋友羊羊在纸上写了n+1个整数，羊羊接着抹除掉了一个整数，给牛牛猜他抹除掉的数字是什么。牛牛知道羊羊写的整数神排序之后是一串连续的正整数，牛牛现在要猜出所有可能是抹除掉的整数。例如：
 10 7 12 8 11 那么抹除掉的整数只可能是9
 5 6 7 8 那么抹除掉的整数可能是4也可能是9

 输入描述:

 输入包括2行：
 第一行为整数n(1 <= n <= 50)，即抹除一个数之后剩下的数字个数
 第二行为n个整数num[i] (1 <= num[i] <= 1000000000)


 输出描述:

 在一行中输出所有可能是抹除掉的数,从小到大输出,用空格分割,行末无空格。如果没有可能的数，则输出mistake
 * Created by Laura on 2017/11/23.
 */
public class ContinuousInt {
    protected static final String MISTAKE = "mistake";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //抹除一个数之后剩下的数字个数
        int[] num = new int[n]; //抹除一个数之后剩下的数字
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        check(num);
    }

    public static  void check(int[] num){
        int len = num.length ;
        if(num == null || len <= 0 || num[0] < 1
                || num[len -1 ] > 1000000000) {
            System.out.println(MISTAKE);
            return;
        }

        //多个数字，先排序
        Arrays.sort(num);

        int min = num[0];
        int max = num[len -1 ];
        int sub = max - min;

        if (sub > len || sub < len - 1) { //中间缺少两个数 或者 有重复的数
            System.out.println(MISTAKE);
        } else if (sub == len - 1){  //中间的数是连续的,包含只有一个数的情况
            if (min > 1) {
                System.out.println(min - 1 + " " + (max + 1));
                return;
            } else {
                System.out.println((max + 1));
                return;
            }
        } else {  //中间的数不是连续的,而且只缺少一个数
            for (int i = 0; i < len-1; i ++) {
                if(num[i] == num[i+1])
                    System.out.println(MISTAKE);
                else if (num[i] + 2 == num[i+1]) {
                    System.out.println(num[i] + 1);
                    break;
                }
            }
        }
    }
}
