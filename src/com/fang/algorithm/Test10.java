/**
 * File��Test11.java
 * Package��com.fang.algorithm
 * Author��chengling
 * Date��2017��11��7�� ����11:10:11
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
 */
package com.fang.algorithm;


/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent��
 * ��base��exponent�η���
 * ˼·��exponent=0 ���� <0
 *     exponent<0�����������ܳ��ֶ�0����
 *     base=0��exponent<0 ����
 * ע�⣺0��0�η� û������
 *     ���ж�base�ǲ��ǵ���0ʱ������ֱ��дbase==0��float��double����ֱ���õȺ��ж�����С���Ƿ���ȡ�
 *     ʹ������Ԫ���Ǵ������2����λ����������������ж���ż
 *    
 */
public class Test10 {
  boolean flag = false;
  
  public double Power(double base, int exponent) {
    int exponentAbs =  Math.abs(exponent);  
    if(Double.compare(base, 0) == 0 && exponent < 0) {
      //base=0��ָ��Ϊ��������Ҫ��0��
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
