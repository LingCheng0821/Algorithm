/**
 * File：Test4.java
 * Package：com.fang.algorithm
 * Author：chengling
 * Date：2017年11月3日 下午3:34:30
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.algorithm;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
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
  
  // 前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
  private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in,
                                         int startIn, int endIn) {
    
    if (startPre > endPre || startIn > endIn)
      return null;
    TreeNode root = new TreeNode(pre[startPre]); //前序遍历
    
    for (int i = startIn; i <= endIn; i++)
      if (in[i] == pre[startPre]) {
        root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn,i - 1);
        root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1,endIn);
      }
    
    return root;
  }
  
}
