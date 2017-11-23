/**
 * File：ConcurrenHashMapDemo.java
 * Package：com.fang.concurrenthashmap
 * Author：chengling
 * Date：2017年9月20日 上午9:51:51
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;


/**
 * @author chengling
 */
public class ConcurrenHashMapDemo {
  private static final int MAXIMUM_CAPACITY = 1 << 30;
  public static void main(String[] args) {   
//    ConcurrentHashMap<String, String> con = new ConcurrentHashMap<String, String>(101);
//    con.put("key", "value");
    
   int initialCapacity = 100;
   int a = initialCapacity >>> 1;  
   int cap = ((initialCapacity >= (MAXIMUM_CAPACITY >>> 1)) ?
      MAXIMUM_CAPACITY :
      tableSizeFor(initialCapacity + a + 1));
   System.err.println(cap);
  }
  private static final int tableSizeFor(int c) {
    int n = c - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    int resule = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    return resule;
}
}
