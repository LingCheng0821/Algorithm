/**
 * File：Mutil_Producer_ConsumerByCondition.java
 * Package：com.fang.condition
 * Author：chengling
 * Date：2017年9月18日 下午1:51:50
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.condition;
public class Mutil_Producer_ConsumerByCondition {

  public static void main(String[] args) {
      ResourceByCondition r = new ResourceByCondition();
      Mutil_Producer pro = new Mutil_Producer(r);
      Mutil_Consumer con = new Mutil_Consumer(r);
//      KaoYaResource r = new KaoYaResource();
//      Producer pro = new Producer(r);
//      Consumer con = new Consumer(r);
      //生产者线程
      Thread t0 = new Thread(pro);
      Thread t1 = new Thread(pro);
      //消费者线程
      Thread t2 = new Thread(con);
      Thread t3 = new Thread(con);
      //启动线程
      t0.start();
      t1.start();
      t2.start();
      t3.start();
  }
}

/**
* @decrition 生产者线程
*/
class Mutil_Producer implements Runnable {
  private ResourceByCondition r;
  private final int m = 10;
  Mutil_Producer(ResourceByCondition r) {
      this.r = r;
  }
  public void run() {
      for (int i = 0; i < m; i++) {
        r.product("北京烤鸭");
      }
  }
}

/**
* @decrition 消费者线程
*/
class Mutil_Consumer implements Runnable {
  private ResourceByCondition r;
  private final int m = 10;
  Mutil_Consumer(ResourceByCondition r) {
      this.r = r;
  }
  public void run() {
    for (int i = 0; i < m; i++) {
          r.consume();
      }
  }
}


class Producer implements Runnable {
  private KaoYaResource r;
  private final int m = 10;
  Producer(KaoYaResource r) {
      this.r = r;
  }
  public void run() {
      for (int i = 0; i < m; i++) {
        r.product("北京烤鸭");
      }
  }
}
class Consumer implements Runnable {
  private KaoYaResource r;
  private final int m = 10;
  Consumer(KaoYaResource r) {
      this.r = r;
  }
  public void run() {
    for (int i = 0; i < m; i++) {
          r.consume();
      }
  }
}
