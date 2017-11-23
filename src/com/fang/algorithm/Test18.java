/**
 * File��Test18.java
 * Package��com.fang.algorithm
 * Author��chengling
 * Date��2017��11��8�� ����1:39:54
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
 */
package com.fang.algorithm;


/**
 * �������ľ���
 * ���������Ķ�����������任ΪԴ�������ľ���
 * �������ľ����壺Դ������ 
          8
         /  \
        6   10
       / \  / \
      5  7 9  11
      ���������
           8
         /   \
        10    6
       / \   / \
      11  9 7   5
      
 */
public class Test18 {
  
  static class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;
      public TreeNode(int val) {
          this.val = val;
      }
  }
  
  public void Mirror(TreeNode root) {
      if(root == null) return;
      if(root.left == null && root.right==null)
          return;
      
      TreeNode temp = root.left;
      root.left = root.right;
      root.right = temp;
      
      if(root.left != null) Mirror(root.left);
      if(root.right != null) Mirror(root.right);      
  }
  
}
