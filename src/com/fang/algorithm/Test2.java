/**
 * File��Test2.java
 * Package��com.fang.algorithm
 * Author��chengling
 * Date��2017��11��3�� ����3:09:57
 * Copyright (C) 2003-2017 �ѷ���Ѷ���޹�˾-��Ȩ����
 */
package com.fang.algorithm;


/**
 * ��ʵ��һ����������һ���ַ����еĿո��滻�ɡ�%20����
 * ���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy��
 */
public class Test2 {
  public String replaceSpace(StringBuffer str) {
    StringBuffer result = new StringBuffer(); 
    if(str == null){
      return null;
    }
    for(int i = 0; i < str.length(); i++){
      if(str.charAt(i) == ' '){
        result.append("%20");
      }else{
        result.append(str.charAt(i));
      }
    }
    
    
    return result.toString();
  }
}
