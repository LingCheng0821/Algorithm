/**
 * File��Test15.java
 * Package��com.fang.algorithm
 * Author��chengling
 * Date��2017��11��7�� ����8:56:36
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
 */
package com.fang.algorithm;

/**
 * �������������ͷָ���һ���ڵ�ָ�룬����һ��������O(1)ʱ��ɾ���ý�㡣
 * ˼·����Ҫɾ�����i,��i������һ�����j���ڴ渴�Ƹ��ǽ��i���ٰ�i����һ�����ָ��j����һ����㣬ɾ�����j��
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
    
    // ֻ��һ����㣬ɾ��ͷ���
    if (head == toBeDelete) {
      toBeDelete = null;
      head = null;
      return null;
    }
    
    // ����β���
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
    
    // ���Դ���
    ListNode head = null;   
    head = new ListNode(1);
    
    /**
     * // (3)ֻ��һ����㣬ɾ��β���(Ҳ��ͷ���)
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
    // (2)�����㣬ɾ��β���
   // print(delete(head, tail));
    
    // (1)ɾ���Ĳ���β���
    print(delete(head, head.next));
    
  }
  
}
