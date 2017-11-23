/**
 * File：Test14.java
 * Package：com.fang.algorithm
 * Author：chengling
 * Date：2017年11月7日 下午5:12:06
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.algorithm;

import com.fang.algorithm.Test13.ListNode;


/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class Test14 {
  
  static class ListNode {
      int val;
      ListNode next = null;

      ListNode(int val) {
          this.val = val;
      }
  }
  
  public ListNode Merge(ListNode list1,ListNode list2) {
    if(list1 == null)  return list2;
    if(list2 == null)  return list1;
    
 /*   if(list1.val <= list2.val){
      list1.next = Merge(list1.next, list2);
      return list1;
    }else {
      list2.next = Merge(list1, list2.next);
      return list2;
    }*/
   
    ListNode mergeHead = null;
    ListNode current = null;     
    while(list1!=null && list2!=null){
        if(list1.val <= list2.val){ 
            if(mergeHead == null){ //第一次进来
               mergeHead = current = list1;
            }else{
               current.next = list1;
               current = current.next;
            }
            list1 = list1.next;
        }else{
            if(mergeHead == null){
               mergeHead = current = list2;
            }else{
               current.next = list2;
               current = current.next;
            }
            list2 = list2.next;
        }
    }
    if(list1 == null) current.next = list2;
    if(list2 == null) current.next = list1;
    
    return mergeHead;
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
    head2.next = head4;
    head3.next = head5;
    head5.next = head6;
    head6.next = head7;
    head7.next = head8;
    ListNode merge = new Test14().Merge(head1, head3);
    while (merge != null) {
      System.err.println(merge.val);
      merge = merge.next;
    }
    
  }
  
  
}
