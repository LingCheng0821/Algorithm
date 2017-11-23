package com.fang.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
  static CyclicBarrier c = new CyclicBarrier(2,new BarrierAction());
  
  public static void main(String[] args) {
    new Thread(new Runnable() {     
      public void run() {
        try {
          c.await();
        }catch (Exception e) {}
        System.out.println(1);
      }
    }).start();
    
    try {
          c.await();
        }catch (Exception e) {}
        System.out.println(2);
     
  }
  
  
  
  static class BarrierAction implements Runnable{
    @Override
    public void run() {
      System.out.println(3);     
    }    
  }
}




