/**
 * File：Test1.java
 * Package：com.fang.algorithm
 * Author：chengling
 * Date：2017年11月2日 下午6:09:57
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.algorithm;


/**
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Test1 {
  
  public boolean Find(int target, int [][] array) {
    boolean flag = false;
        int rowSize = array.length;
        int colSize = array[0].length;
   
        for(int i = rowSize-1, j = 0; i >= 0 && j < colSize;){
            if(target == array[i][j]){
                flag = true;
                break;
            } else if (target < array[i][j]){
                i--;
            } else {
                j++;                 
            }
        }
        return flag;
    }
  
  public static void main(String[] arg){
    int[][] array={{1,3,5},{},{2,4,6},{3,5,7}};
    int target = 4;
    
  }
  
}
