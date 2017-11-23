/**
 * File：BoundedQueue.java
 * Package：com.fang.condition.boundqueue
 * Author：chengling
 * Date：2017年9月18日 下午2:04:25
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.condition.boundqueue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author chengling
 */
public class BoundedQueue<T> {
  private Object[] items;
  private int addIndex,removeIndex,count;
  private Lock lock = new ReentrantLock();
  private Condition notEmpty = lock.newCondition();
  private Condition notFull = lock.newCondition();
  
  public BoundedQueue(int size){
    items = new Object[size];
  }
  
  public void add(T t) throws InterruptedException{
    lock.lock();
    try{
      while(count == items.length)
        notFull.await();
      items[addIndex] = t;
      if(++addIndex == items.length)
        addIndex = 0;
      ++count;
      notEmpty.signal();
    }finally{
      lock.unlock();
    }
  }
}
