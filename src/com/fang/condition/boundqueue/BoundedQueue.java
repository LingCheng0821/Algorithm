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
