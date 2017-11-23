/**
 * File��Test3.java
 * Package��com.fang.algorithm
 * Author��chengling
 * Date��2017��11��3�� ����3:15:39
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
 */
package com.fang.algorithm;

import java.util.ArrayList;
import java.util.Stack;
/**
 * ����һ��������β��ͷ��ӡ����ÿ���ڵ��ֵ��
 */
public class Test3 {
  private static ArrayList<Integer> result = new ArrayList<>();
  static class ListNode {   
    int val;    
    ListNode next = null;    
    ListNode(int val) {
      this.val = val;
    }
  }
  
  
  public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
    
    /*Stack<Integer> stack = new Stack<>();
    while(listNode != null){
      stack.push(listNode.val);
      listNode=listNode.next;
    }
    while(!stack.isEmpty()){
      result.add(stack.pop());
    }*/
    
    if(listNode == null){
      return result;
    }
    printListFromTailToHead(listNode.next);
    result.add(listNode.val);
    
    return result;
  }
  
  public static void main(String[] args) {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    node1.next = node2;
    node2.next = node3;
    ArrayList<Integer> result = Test3.printListFromTailToHead(node1);
    for (Integer integer : result) {
      System.err.println(integer);
    }
  }
}
