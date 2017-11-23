/**
 * File：ArrayBlockingQueueDemo.java
 * Package：com.fang.arrayblockingqueue
 * Author：chengling
 * Date：2017年10月23日 下午10:43:24
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.arrayblockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


public class ArrayBlockingQueueDemo {
  private final static ArrayBlockingQueue<Apple> queue= new ArrayBlockingQueue<>(1);
  public static void main(String[] args){
      new Thread(new Producer(queue)).start();
//      new Thread(new Producer(queue)).start();
//      new Thread(new Consumer(queue)).start();
      new Thread(new Consumer(queue)).start();
  }
}

class Apple {
  public Apple(){
  }
}

/**
* 生产者线程
*/
class Producer implements Runnable{
  private final ArrayBlockingQueue<Apple> mAbq;
  Producer(ArrayBlockingQueue<Apple> arrayBlockingQueue){
      this.mAbq = arrayBlockingQueue;
  }

  @Override
  public void run() {
      while (true) {
          Produce();
      }
  }

  private void Produce(){
      try {
          TimeUnit.MILLISECONDS.sleep(1000);
          Apple apple = new Apple();
          System.out.println("生产Apple="+apple);
          mAbq.put(apple);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
  }
}

/**
* 消费者线程
*/
class Consumer implements Runnable{

  private ArrayBlockingQueue<Apple> mAbq;
  Consumer(ArrayBlockingQueue<Apple> arrayBlockingQueue){
      this.mAbq = arrayBlockingQueue;
  }

  @Override
  public void run() {
      while (true){
          try {             
              comsume();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
      }
  }

  private void comsume() throws InterruptedException {
      Apple apple = mAbq.take();
      System.out.println("消费Apple="+apple);
  }
}
