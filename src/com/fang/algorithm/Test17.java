/**
 * File：Test17.java
 * Package：com.fang.algorithm
 * Author：chengling
 * Date：2017年11月8日 上午9:51:40
 * Copyright (C) 2003-2017 搜房资讯有限公司-版权所有
 */
package com.fang.algorithm;


/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class Test17 { 
 
  static class TreeNode {
      int val = 0;
      TreeNode left = null;
      TreeNode right = null;

      public TreeNode(int val) {
          this.val = val;
      }
  }
  
  
  public boolean HasSubtree(TreeNode root1,TreeNode root2) {    
    if(root2 == null) return true;
    if(root1 == null) return false;
    boolean flag = false;    
    if(root1.val == root2.val) flag = isSUbTree(root1,root2);
    if(!flag) flag = HasSubtree(root1.left, root2);
    if(!flag) flag = HasSubtree(root1.right, root2);    
    return flag;
  }
  
  private boolean isSUbTree(TreeNode root1, TreeNode root2) {
    if(root2 == null) return true;
    if(root1 == null) return false;
    if(root1.val != root2.val)
      return false;
    return isSUbTree(root1.left, root2.left) && isSUbTree(root1.right, root2.right);
  }
}
