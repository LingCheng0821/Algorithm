/**
 * File：Test13.java
 * Package：com.fang.algorithm
 * Author：chengling
 * Date：2017年11月7日 下午3:13:57
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.algorithm;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Test13 {
  
  static class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
          this.val = val;
      }
  }
  
  
  public ListNode FindKthToTail(ListNode head, int k) {
    if(k <= 0 || head == null)
     return null;
    ListNode result = head;
    int i = 0;
    
    while(head != null){
      i++;
      head = head.next;
      if(i > k){
        result = result.next;
      }      
    } 
    if(k > i){
      return null;
    }
    return result;
  }
  
  public static void main(String[] args) {
    ListNode head1 = new ListNode(1);
    ListNode head2 = new ListNode(2);
    ListNode head3 = new ListNode(3);
    ListNode head4 = new ListNode(4);
    ListNode head5 = new ListNode(5);   
    ListNode head6 = new ListNode(6);
    ListNode head7 = new ListNode(7);
    ListNode head8 = new ListNode(8);
    head1.next = head2;
    head2.next = head3;
    head3.next = head4;
    head4.next = head5;
    head5.next = head6;
    head6.next = head7;
    head7.next = head8;
    
    ListNode  result = new Test13().FindKthToTail(head1, 10);
    System.err.println(result.val);
    
  }
  
}
