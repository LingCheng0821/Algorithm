package com.fang.singleton;

public class Singleton {
  
  private Singleton(){};
  
 
  /**
   *  1������ģʽ 
   */ 
 /* 
    private static final Singleton instance = new Singleton();
    public static Singleton getInstance(){
      return instance;
    }
  */
  
  /**
   * 2������ȫ������ģʽ
   */
  /*
     private static Singleton instance;
     public static Singleton getInstance(){
       if(instance == null)
         instance = new Singleton();
       return instance;
     }
   */
  
  /**
   * 3������ȫ��˫�ؼ������
   */
  
   /*
       private static Singleton instance;
       public static Singleton getInstance(){
         if(instance == null){
           synchronized (Singleton.class) {
             if(instance == null)
               instance = new Singleton();
          }
         }
         return instance;
       }
     */
   
  /**
   * 4����ȫ��˫�ؼ������
   */
 /* 
    private volatile static Singleton instance;
    public static Singleton getInstance(){
      if(instance == null){
        synchronized (Singleton.class) {
          if(instance == null)
            instance = new Singleton();
        }      
      }
      return instance;
    }
  */
  
  /**
   * 5�����ʼ���Ľ������
   */ 
   /*
      private static class InstanceHolder{
        public static Singleton instance = new Singleton();
      }
      
      public static Singleton getInstance(){
        return InstanceHolder.instance;
      }
    */
  
//  public enum Singleton{
//    INSTANCE;
//  }
  
 
    
    private static enum Singleton1{
        INSTANCE;
        
        public static Singleton1 getInst(){
          return INSTANCE;
        }
    }

}
