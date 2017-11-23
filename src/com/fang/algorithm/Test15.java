/**
 * File：Test15.java
 * Package：com.fang.algorithm
 * Author：chengling
 * Date：2017年11月7日 下午8:56:36
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.algorithm;

/**
 * 给定单向链表的头指针和一个节点指针，定义一个函数在O(1)时建删除该结点。
 * 思路：需要删除结点i,把i结点的下一个结点j的内存复制覆盖结点i，再把i的下一个结点指向j的下一个结点，删除结点j。
 */
public class Test15 {
  
  static class ListNode {
    
    int val;
    
    ListNode next = null;
    
    ListNode(int val) {
      this.val = val;
    }
  }
  
  public static ListNode delete(ListNode head, ListNode toBeDelete) {
    if (head == null || toBeDelete == null) {
      return null;
    }
    
    // 只有一个结点，删除头结点
    if (head == toBeDelete) {
      toBeDelete = null;
      head = null;
      return null;
    }
    
    // 不是尾结点
    if (toBeDelete.next != null) {
      ListNode nextNode = toBeDelete.next;
      toBeDelete.val = nextNode.val;
      toBeDelete.next = nextNode.next;
      nextNode = null;
    }
    else {
      ListNode node = head;
      while (node.next != toBeDelete) {
        node = node.next;
      }
      node.next = null;
      toBeDelete = null;
    }
    return head;
  }
  
  public static void print(ListNode head) {
    if (head == null) {
      System.out.println("list is null");
    }
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
  
  public static void main(String[] args) {
    
    // 测试代码
    ListNode head = null;   
    head = new ListNode(1);
    
    /**
     * // (3)只有一个结点，删除尾结点(也是头结点)
     * print(head);
     * print(delete(head, head));
    */
   
    
    ListNode p = head;
    for (int i = 2; i < 6; i++) {    
      ListNode node = new ListNode(i);
      p.next = node;
      p = p.next;
    }   
    ListNode tail = new ListNode(6);
    p.next = tail;
    
    print(head);   
    // (2)多个结点，删除尾结点
   // print(delete(head, tail));
    
    // (1)删除的不是尾结点
    print(delete(head, head.next));
    
  }
  
}
