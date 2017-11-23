/**
 * File：LockDemo.java
 * Package：com.fang.lock
 * Author：chengling
 * Date：2017年9月6日 下午6:11:38
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author chengling
 */
public class LockDemo {
  private static char ch = 'A';
  private static LockDemo lock = new LockDemo();
  public static void main(String[] args) {
    Thread A = new Thread(new ThreadA(),"A");
    Thread B = new Thread(new ThreadB(),"B");
    A.start();
    B.start();
  }
  
  static class ThreadA implements Runnable{
    @Override
    public void run() {
      for (int i = 0; i < 26; i++) {
        synchronized (lock) {
          System.out.print(i+1);
          lock.notify();
          try {
            lock.wait();
          }
          catch (InterruptedException e) {}
        }       
      }      
    }    
  }
  
  static class ThreadB implements Runnable{
    @Override
    public void run() {
      for (int i = 0; i < 26; i++) {
        synchronized (lock) {
          System.out.print(ch++);
          lock.notify();
          try {
            lock.wait();
          }
          catch (InterruptedException e) {}
        }       
      }      
    }    
  }
}
