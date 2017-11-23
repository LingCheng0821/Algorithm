/**
 * File��Test16.java
 * Package��com.fang.algorithm
 * Author��chengling
 * Date��2017��11��7�� ����10:06:35
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
 */
package com.fang.algorithm;

import com.fang.algorithm.Test15.ListNode;


/**
 * ��ת����
 * ����һ�������ͷ��㣬��ת�����������ת�������ͷ���
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
   
   // ���Դ���
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
