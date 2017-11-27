package com.fang.algorithm2;

import java.util.Scanner;

/**
 * 给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。
 * 例如 N = 18 L = 2：
 * 5 + 6 + 7 = 18
 * 3 + 4 + 5 + 6 = 18
 * 都是满足要求的，但是我们输出更短的 5 6 7
 * 输入描述:
 * 输入数据包括一行： 两个正整数N(1 ≤ N ≤ 1000000000),L(2 ≤ L ≤ 100)
 * 输出描述:
 * 从小到大输出这段连续非负整数，以空格分隔，行末无空格。如果没有这样的序列或者找出的序列长度大于100，则输出No
 *
 * 分析：(a1 + an) * n / 2 = N
 * 则 a1 = (2N+n-n^2) / 2n
 * Created by Laura on 2017/11/24.
 */
public class sequenceSum {
    protected static final String no = "No";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        int L = sc.nextInt();
        System.out.println(check(543792409,57));
    }

    public static String check(int N, int L){
        if(N < 1 || N > 1000000000 || L < 2 || L > 100)
            return no;
        if(L > N)   return no;

        StringBuilder result = new StringBuilder();

        for (int i = L; i<= 100 && i < N; i++) {
            if((2*N+i-i*i)%(2*i) == 0) {
                int start = (2 * N + i - i * i) / (2 * i);
                for (int j = 0; j < i - 1; j++) {
                    result.append(start + j).append(" ");
                }
                result.append(start + i - 1);
                return result.toString();
            }
        }
        return no;
    }

}
