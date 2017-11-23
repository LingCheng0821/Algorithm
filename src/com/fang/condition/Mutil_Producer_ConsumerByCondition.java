/**
 * File��Mutil_Producer_ConsumerByCondition.java
 * Package��com.fang.condition
 * Author��chengling
 * Date��2017��9��18�� ����1:51:50
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
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
      //�������߳�
      Thread t0 = new Thread(pro);
      Thread t1 = new Thread(pro);
      //�������߳�
      Thread t2 = new Thread(con);
      Thread t3 = new Thread(con);
      //�����߳�
      t0.start();
      t1.start();
      t2.start();
      t3.start();
  }
}

/**
* @decrition �������߳�
*/
class Mutil_Producer implements Runnable {
  private ResourceByCondition r;
  private final int m = 10;
  Mutil_Producer(ResourceByCondition r) {
      this.r = r;
  }
  public void run() {
      for (int i = 0; i < m; i++) {
        r.product("������Ѽ");
      }
  }
}

/**
* @decrition �������߳�
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
        r.product("������Ѽ");
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
