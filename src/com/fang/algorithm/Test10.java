/**
 * File：Test11.java
 * Package：com.fang.algorithm
 * Author：chengling
 * Date：2017年11月7日 上午11:10:11
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.algorithm;


/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 * 思路：exponent=0 或者 <0
 *     exponent<0，求导数，可能出现对0求导数
 *     base=0，exponent<0 ？？
 * 注意：0的0次方 没有意义
 *     当判断base是不是等于0时，不能直接写base==0【float和double不能直接用等号判断两个小数是否相等】
 *     使用右移元素那代替除以2，用位于运算代替求余来判断奇偶
 *    
 */
public class Test10 {
  boolean flag = false;
  
  public double Power(double base, int exponent) {
    int exponentAbs =  Math.abs(exponent);  
    if(Double.compare(base, 0) == 0 && exponent < 0) {
      //base=0，指数为负数，需要对0求导
      throw new RuntimeException("has error"); 
    } 
    double result = PowerWithUnsignedExponent(base, exponentAbs);
    if(exponent < 0)
      result = 1.0 / result;     
    return result;
  }
  
  public double PowerWithUnsignedExponent(double base, int exponent) {      
    if(exponent == 0)
      return 1;
    if(exponent == 1)
      return base;
    double result = PowerWithUnsignedExponent(base, exponent>>1);
    result *= result;
    if((exponent & 0x1) == 1)
      result *= base;
    return result;
  }
  
  public static void main(String[] args) {
    Test10 test = new Test10();
    System.err.println(test.PowerWithUnsignedExponent(5, 3));
  }
}
