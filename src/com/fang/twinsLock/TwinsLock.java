package com.fang.twinsLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;


/**
 * 同一时刻支持多个线程的访问
 */
public class TwinsLock implements Lock{

  private static final long serialVersionUID = 5042909912282186245L;
  
  private final Sync sync = new Sync(2);
  
  private static final class Sync extends AbstractQueuedSynchronizer {

    private static final long serialVersionUID = 7874821055316886110L;
    
    Sync(int count){
      if(count <=0 ){
        throw new IllegalArgumentException("count must larfe than zero.");
      }
      setState(count);
    }
    
    @Override
    protected int tryAcquireShared(int reduceCount) {
      for(;;){
        int current = getState();
        int newCount = current - reduceCount;
        if(newCount<0 || compareAndSetState(current, newCount)){
          return newCount ;
        }
      }
    }
    @Override
    protected boolean tryRelease(int arg) {
      for(;;){
        int current = getState();
        int newCount = current + arg;
        if(compareAndSetState(current, newCount)){
          return true ;
        }
      }
    }
    
  }

  @Override
  public void lock() {
    sync.tryAcquireShared(1);
  }


  @Override
  public void unlock() {
    sync.tryRelease(1);
  }


  @Override
  public void lockInterruptibly() throws InterruptedException {
  }


  @Override
  public boolean tryLock() {
    return false;
  }


  @Override
  public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
    return false;
  }


  @Override
  public Condition newCondition() {
    return null;
  }

  
}
