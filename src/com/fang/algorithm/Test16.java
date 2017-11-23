/**
 * File：Test16.java
 * Package：com.fang.algorithm
 * Author：chengling
 * Date：2017年11月7日 下午10:06:35
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.algorithm;

import com.fang.algorithm.Test15.ListNode;


/**
 * 反转链表
 * 输入一个链表的头结点，反转该链表并输出反转后链表的头结点
 */
public class Test16 {
  
 static class ListNode {  
    int val;   
    ListNode next = null;   
    ListNode(int val) {
      this.val = val;
    }
 }
 
 public static ListNode reverse(ListNode head){ 
   ListNode pReversedHead = null;
   ListNode pNode = head;
   ListNode pPrev = null;
   
   while(pNode != null){
     ListNode pNext = pNode.next;
     if(pNext == null) 
       pReversedHead = pNode;
     pNode.next = pPrev;
     pPrev = pNode;
     pNode = pNext;
   }   
   return pReversedHead;
 }
 
 public static void print(ListNode head) {
   if (head == null) System.out.println("list is null");
   while (head != null) {
     System.out.print(head.val + "-->");
     head = head.next;
   }
   System.out.println("-------------------------");
 }
 
 public static void main(String[] args) {
   
   // 测试代码
   ListNode head = null;   
   print(reverse(head));
   
   head = new ListNode(1);
   print(reverse(head));
  
   ListNode p = head;
   for (int i = 2; i < 6; i++) {    
     ListNode node = new ListNode(i);
     p.next = node;
     p = p.next;
   }   
   print(reverse(head));
   
 }
 
}
