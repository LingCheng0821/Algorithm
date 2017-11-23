/**
 * File��Test4.java
 * Package��com.fang.algorithm
 * Author��chengling
 * Date��2017��11��3�� ����3:34:30
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
 */
package com.fang.algorithm;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */
public class Test4 {
  
  static class TreeNode {
    
    int val;
    
    TreeNode left;
    
    TreeNode right;
    
    TreeNode(int x) {
      val = x;
    }
  }
  
  public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
    TreeNode root = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    return root;
  }
  
  // ǰ�����{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}
  private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in,
                                         int startIn, int endIn) {
    
    if (startPre > endPre || startIn > endIn)
      return null;
    TreeNode root = new TreeNode(pre[startPre]); //ǰ�����
    
    for (int i = startIn; i <= endIn; i++)
      if (in[i] == pre[startPre]) {
        root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn,i - 1);
        root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1,endIn);
      }
    
    return root;
  }
  
}
