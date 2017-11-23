/**
 * File：HowManyFish.java
 * Package：com.fang.algorithm2
 * Author：chengling
 * Date：2017年11月23日 下午1:49:26
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.algorithm2;

import java.util.Scanner;

/**
 * 
 * 牛牛有一个鱼缸。鱼缸里面已经有n条鱼，每条鱼的大小为fishSize[i] (1 ≤ i ≤ n,均为正整数)，牛牛现在想把新捕捉的鱼放入鱼缸。
 * 鱼缸内存在着大鱼吃小鱼的定律。经过观察，牛牛发现一条鱼A的大小为另外一条鱼B大小的2倍到10倍(包括2倍大小和10倍大小)，鱼A会吃掉鱼B。
 * 考虑到这个，牛牛要放入的鱼就需要保证：
 * 1、放进去的鱼是安全的，不会被其他鱼吃掉
 * 2、这条鱼放进去也不能吃掉其他鱼
 * 鱼缸里面已经存在的鱼已经相处了很久，不考虑他们互相捕食。
 * 现在知道新放入鱼的大小范围[minSize,maxSize](考虑鱼的大小都是整数表示),牛牛想知道有多少种大小的鱼可以放入这个鱼缸。
 * 
 * 输入描述:
 * 输入数据包括3行. 第一行为新放入鱼的尺寸范围minSize,maxSize(1 ≤ minSize,maxSize ≤ 1000)，以空格分隔。
 * 第二行为鱼缸里面已经有鱼的数量n(1 ≤ n ≤ 50)
 * 第三行为已经有的鱼的大小fishSize[i](1 ≤ fishSize[i] ≤ 1000)，以空格分隔。
 * 输出描述:
 * 输出有多少种大小的鱼可以放入这个鱼缸。考虑鱼的大小都是整数表示
 * 
 * 例如：
 * 输入： 1 12 1 1
 * 输出：3
 */
public class HowManyFish {
  
  public static void main(String[] args) {
    // 接受输入参数
    Scanner scanner = new Scanner(System.in);
    System.out.println("新放入鱼范围的最小值:");
    int minSize = scanner.nextInt(); // 新放入鱼范围的最小值
    System.out.println("新放入鱼范围的最大值:");
    int maxSize = scanner.nextInt();// 新放入鱼范围的最大值
    System.out.println("鱼缸里面已经有鱼的数量:");
    int inNumber = scanner.nextInt();// 鱼缸里面已经有鱼的数量
    int[] inFishSize = new int[inNumber]; // 定义一个数组
    System.out.println(" 初始化已经有的鱼的大小:");
    for (int i = 0; i < inNumber; i++) {
      inFishSize[i] = scanner.nextInt();// 初始化已经有的鱼的大小inFishSize[i]
    }
    int canPut = 0;// 可以放进鱼的种类数
    
    for (int i = minSize; i <= maxSize; i++) { // 遍历输入的范围，逐个查看每中大小的鱼是否可以放进去
      boolean willBeEaten = false; // 是否被吃，true 被吃。
      for (int j = 0; j < inNumber; j++) {
        if ((10 * i >= inFishSize[j] && 2 * i <= inFishSize[j])
            || (i >= inFishSize[j] * 2 && i <= inFishSize[j] * 10)) {
          willBeEaten = true;
          break; // 一旦发现此鱼不能放进去，break，跳出循环，避免多余的检查
        }
      }
      // 如果这条鱼可以不被鱼缸中其他鱼吃。或者被吃。则canPut++
      if (!willBeEaten) {
        System.out.println(i);
        canPut++;
      }
    }1
    System.out.println(canPut);
  }
}
