/**
 * File��Test13.java
 * Package��com.fang.algorithm
 * Author��chengling
 * Date��2017��11��7�� ����2:52:00
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
 */
package com.fang.algorithm;

import java.util.HashMap;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 */
public class Test12 {
  
  public void reOrderArray(int[] array) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int length = array.length;
    int[] result = array;
    int index = 0;
    int arr = 0;
    for (int i = 0; i < length; i++) {
      if ((result[i] & 0x1) == 1) {
        array[index++] = result[i];
      }
      else {
        map.put(arr++, result[i]);
      }
    }
    for (int i = 0; i < arr; i++) {
      array[index++] = map.get(i);
    }
    for (int i : array) {
      System.err.println(i);
    }
   
  }
  
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 5, 6, 7};
    new Test12().reOrderArray(array);
  }
}
