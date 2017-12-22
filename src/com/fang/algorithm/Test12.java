package com.fang.algorithm;

import java.util.HashMap;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
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
